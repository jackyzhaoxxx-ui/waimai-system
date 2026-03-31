package com.cc.reggie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.reggie.common.R;
import com.cc.reggie.dto.DishDto;
import com.cc.reggie.dto.SetmealDto;
import com.cc.reggie.entity.Setmeal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 郑梓聪
 * @description 套餐管理业务接口
 * @date 2022-06-22
 */
public interface SetmealService extends IService<Setmeal> {


    //套餐信息分页
    public R<Page> page(int page, int pageSize, String name);

    //删除套餐
    public R<String> delete(@RequestParam List<Long> ids);

    //查询套餐列表
    public R<List<Setmeal>> list(Setmeal setmeal);

    // 新增套餐,同时需要保存套餐与菜品的关系
    void saveWithDish(SetmealDto setmealDto);

    // 删除套餐，同时删除套餐与菜品的关系
    void removeWithDish(List<Long> ids);

    //移动端点击套餐图片查看套餐具体内容
    public R<List<DishDto>> dish(@PathVariable("id") Long SetmealId);

    //更新套餐状态
    public void updateStatus(Integer status, List<Long> ids);

    //根据套餐id查询套餐信息
    SetmealDto getByIdWithDish(@PathVariable Long id);

    //修改套餐
    void updateWithDish(@RequestBody SetmealDto setmealDto);
}
