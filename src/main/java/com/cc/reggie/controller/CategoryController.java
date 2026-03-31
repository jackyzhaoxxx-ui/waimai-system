package com.cc.reggie.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.reggie.common.R;
import com.cc.reggie.entity.Category;
import com.cc.reggie.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜品分类控制器
 *
 * @author 郑梓聪
 * @date 2022-06-21
 */
@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 添加菜品分类
     *
     * @return
     */
    @PostMapping
    public R<String> saveCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
        return R.success("新增分类成功！");
    }

    /**
     * 分页查询
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize) {
        return categoryService.page(page, pageSize);
    }

    /**
     * 根据id删除分类
     *
     * @param id
     * @return
     */
    @DeleteMapping
    public R<String> delete(Long id) {
        categoryService.removeById(id);
        return R.success("删除分类成功！");
    }

    /**
     * 根据id修改分类信息
     *
     * @param category
     * @return
     */
    @PutMapping
    public R<String> update(@RequestBody Category category) {
        categoryService.updateById(category);
        return R.success("修改分类成功！");
    }

    /**
     * 根据条件查询分类数据
     *
     * @param category
     * @return
     */
    @GetMapping("/list")
    public R<List<Category>> list(Category category) {
        return categoryService.list(category);
    }
}
