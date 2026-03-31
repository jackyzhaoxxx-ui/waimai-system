package com.cc.reggie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.reggie.common.R;
import com.cc.reggie.dto.DishDto;
import com.cc.reggie.entity.Dish;

import java.util.List;

/**
 * 菜品管理业务层
 *
 * @author 郑梓聪
 * @date 2022-06-22
 */
public interface DishService extends IService<Dish> {
    //新增菜品，同时插入菜品对应的口味数据，需要操作两张表：dish、dish_flavor
    public void saveWithFlavor(DishDto dishDto);

    //根据菜品id删除菜品及其对应的口味数据
    public DishDto getByIdWithFlavor(Long id);

    //更新菜品及其对应的口味数据
    public void updateWithFlavor(DishDto dishDto);

    //分页查询菜品信息
    public R<Page> page(int page, int pageSize, String name);

    //根据菜品id查询菜品信息
    public R<List<DishDto>> list(Dish dish);

    //批量停售、起售菜品
    public void updateStatus(Integer status, List<Long> ids);

    //批量删除菜品
    public void deleteByIds(List<Long> ids);
}
