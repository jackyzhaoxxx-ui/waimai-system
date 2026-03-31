package com.cc.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.reggie.common.CustomException;
import com.cc.reggie.common.R;
import com.cc.reggie.dto.DishDto;
import com.cc.reggie.entity.Category;
import com.cc.reggie.entity.Dish;
import com.cc.reggie.entity.DishFlavor;
import com.cc.reggie.mapper.DishMapper;
import com.cc.reggie.service.CategoryService;
import com.cc.reggie.service.DishFlavorService;
import com.cc.reggie.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 菜品管理业务接口层
 *
 * @author 郑梓聪
 * @date 2022-06-22
 */
@Service
@Slf4j
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
    @Autowired
    private DishService dishService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private DishFlavorService dishFlavorService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * //新增菜品，同时保存菜品对应的口味数据
     *
     * @param dishDto
     */
    @Transactional
    public void saveWithFlavor(DishDto dishDto) {
        //保存菜品的基本信息到菜品表
        this.save(dishDto);

        Long dishId = dishDto.getId();//菜品id

        //菜品口味
        List<DishFlavor> flavors = dishDto.getFlavors();
        flavors.stream().map((item) -> {
            item.setDishId(dishId);
            return item;
        }).collect(Collectors.toList());

        //保存菜品口味数据到菜品口味表dish flavor
        dishFlavorService.saveBatch(flavors);
    }

    /**
     * 根据菜品id删除菜品及其对应的口味数据
     *
     * @param id
     * @return
     */
    public DishDto getByIdWithFlavor(Long id) {
        //查询菜品基本信息
        Dish dish = this.getById(id);

        //对象拷贝
        DishDto dishDto = new DishDto();
        BeanUtils.copyProperties(dish, dishDto);

        //查询菜品口味信息
        LambdaQueryWrapper<DishFlavor> queryWrappe = new LambdaQueryWrapper<>();
        queryWrappe.eq(DishFlavor::getDishId, dish.getId());
        List<DishFlavor> flavors = dishFlavorService.list(queryWrappe);
        dishDto.setFlavors(flavors);

        return dishDto;
    }

    /**
     * //更新菜品，同时更新菜品对应的口味数据
     *
     * @param dishDto
     */
    @Transactional
    public void updateWithFlavor(DishDto dishDto) {
        //更新菜品基本信息
        this.updateById(dishDto);

        //清理菜品口味数据
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId, dishDto.getId());

        dishFlavorService.remove(queryWrapper);

        //更新菜品口味信息
        List<DishFlavor> flavors = dishDto.getFlavors();

        flavors = flavors.stream().map((item) -> {
            item.setDishId(dishDto.getId());
            return item;
        }).collect(Collectors.toList());

        dishFlavorService.saveBatch(flavors);
    }

    /**
     * 菜品信息分页
     *
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @Transactional
    @Override
    public R<Page> page(int page, int pageSize, String name) {
        //构造分页构造器对象
        Page<Dish> pageIfo = new Page<>(page, pageSize);
        Page<DishDto> dishDtoPage = new Page<>();

        //条件构造器
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        //添加过滤条件
        queryWrapper.like(name != null, Dish::getName, name);

        //执行分页查询
        dishService.page(pageIfo, queryWrapper);

        //对象拷贝
        BeanUtils.copyProperties(pageIfo, dishDtoPage, "records");

        List<Dish> records = pageIfo.getRecords();//获取分页数据
        List<DishDto> list = records.stream().map((item) -> {//对分页数据进行处理
            DishDto dishDto = new DishDto();//菜品DTO对象

            BeanUtils.copyProperties(item, dishDto);//对象拷贝

            Long categoryId = item.getCategoryId();//分类id
            Category category = categoryService.getById(categoryId);//根据分类id查询分类信息

            if (category != null) {//分类信息不为空
                String categoryName = category.getName();//分类名称
                dishDto.setCategoryName(categoryName);//设置分类名称
            }
            return dishDto;//返回菜品DTO对象
        }).collect(Collectors.toList());//转换成List集合

        dishDtoPage.setRecords(list);//设置分页数据

        return R.success(dishDtoPage);
    }

    /**
     * 根据条件查询菜品信息
     *
     * @param dish
     * @return
     */
    @Transactional
    @Override
    public R<List<DishDto>> list(Dish dish) {
        List<DishDto> dishDtoList = null;

        //缓存key
        String key = "dish_" + dish.getCategoryId() + "_" + dish.getName();//dish_categoryId_name

        //先从redis中查询是否有缓存数据
        dishDtoList = (List<DishDto>) redisTemplate.opsForValue().get(key);

        if (dishDtoList != null) {
            //如果存在缓存数据，则直接返回缓存数据
            return R.success(dishDtoList);
        }

        //条件构造器
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        //分类id
        queryWrapper.eq(dish.getCategoryId() != null, Dish::getCategoryId, dish.getCategoryId());
        //查询状态为1，起售状态
        queryWrapper.eq(Dish::getStatus, 1);

        //添加排序条件
        queryWrapper.orderByAsc(Dish::getSort).orderByDesc(Dish::getUpdateTime);
        List<Dish> list = dishService.list(queryWrapper);

        dishDtoList = list.stream().map((item) -> {//对分页数据进行处理
            DishDto dishDto = new DishDto();//菜品DTO对象

            BeanUtils.copyProperties(item, dishDto);//对象拷贝

            Long categoryId = item.getCategoryId();//分类id
            Category category = categoryService.getById(categoryId);//根据分类id查询分类信息

            if (category != null) {//分类信息不为空
                String categoryName = category.getName();//分类名称
                dishDto.setCategoryName(categoryName);//设置分类名称
            }

            //当前菜品id
            Long dishId = item.getId();
            LambdaQueryWrapper<DishFlavor> queryWrapper1 = new LambdaQueryWrapper<>();
            queryWrapper1.eq(DishFlavor::getDishId, dishId);
            //SQL: SELECT * FROM dish_flavor WHERE dish_id = ?
            List<DishFlavor> dishFlavorList = dishFlavorService.list(queryWrapper1);
            dishDto.setFlavors(dishFlavorList);//设置口味信息

            return dishDto;//返回菜品DTO对象
        }).collect(Collectors.toList());//转换成List集合

        //如果不存在缓存数据，则查询数据库，并将数据添加到缓存中
        redisTemplate.opsForValue().set(key, dishDtoList, 60, TimeUnit.MINUTES);

        return R.success(dishDtoList);
    }

    /**
     * 对菜品批量或者是单个 进行停售或者是起售
     *
     * @return
     */
    @PostMapping("/status/{status}")
    //这个参数这里一定记得加注解才能获取到参数，否则这里非常容易出问题
    public R<String> status(@PathVariable("status") Integer status, @RequestParam List<Long> ids) {
        dishService.updateStatus(status, ids);
        return R.success("售卖状态修改成功");
    }

    /**
     * 套餐批量删除和单个删除
     *
     * @return
     */
    @DeleteMapping
    public R<String> delete(@RequestParam("ids") List<Long> ids) {
        //删除菜品  这里的删除是逻辑删除
        dishService.deleteByIds(ids);
        //删除菜品对应的口味  也是逻辑删除
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(DishFlavor::getDishId, ids);
        dishFlavorService.remove(queryWrapper);

//        //清理所有菜品的缓存数据,不知道菜品数据怎么获取。。。
//        Set keys = redisTemplate.keys("dish_*"); //获取所有以dish_xxx开头的key
//        redisTemplate.delete(keys); //删除这些key


        return R.success("菜品删除成功");
    }

    /**
     * 批量停售套餐
     *
     * @param status
     * @param ids
     */
    @Override
    @Transactional
    public void updateStatus(Integer status, List<Long> ids) {
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.in(ids != null, Dish::getId, ids);
        //根据数据进行批量查询
        List<Dish> list = dishService.list(queryWrapper);

        for (Dish dish : list) {
            if (dish != null) {
                dish.setStatus(status);
                dishService.updateById(dish);
            }
        }

    }

    /**
     * 套餐批量删除和单个删除
     *
     * @param ids
     */
    @Override
    @Transactional
    public void deleteByIds(List<Long> ids) {

        //构造条件查询器
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        //先查询该菜品是否在售卖，如果是则抛出业务异常
        queryWrapper.in(ids != null, Dish::getId, ids);
        List<Dish> list = this.list(queryWrapper);
        for (Dish dish : list) {
            Integer status = dish.getStatus();
            //如果不是在售卖,则可以删除
            if (status == 0) {
                this.removeById(dish.getId());
            } else {
                //此时应该回滚,因为可能前面的删除了，但是后面的是正在售卖
                throw new CustomException("删除菜品中有正在售卖菜品,无法全部删除");
            }
        }

    }
}
