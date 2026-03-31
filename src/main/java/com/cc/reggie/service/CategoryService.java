package com.cc.reggie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.reggie.common.R;
import com.cc.reggie.entity.Category;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 菜品分类业务接口
 *
 * @author 郑梓聪
 * @since 2022-06-21
 */
public interface CategoryService extends IService<Category> {
    //添加分类
    public R<String> saveCategory(@RequestBody Category category);

    //分页查询
    public R<Page> page(int page, int pageSize);

    //删除分类
    public R<String> delete(Long id);

    public void remove(Long id);

    //更新分类信息
    public R<String> update(@RequestBody Category category);

    //分类列表查询
    public R<List<Category>> list(Category category);

}
