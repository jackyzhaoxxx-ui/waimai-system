package com.cc.reggie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.reggie.common.R;
import com.cc.reggie.entity.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 管理员工服务类
 * </p>
 *
 * @author 郑梓聪
 * @since 2022-06-20
 */
public interface EmployeeService extends IService<Employee> {
   //员工登录
    public R<Object> login(HttpServletRequest request, @RequestBody Employee employee);

    //员工退出
    public R<String> logout(HttpServletRequest request);

    //新增员工
    public R<String> save(HttpServletRequest request, @RequestBody Employee employee);

    //员工分页
    public R<Page> page(int page, int pageSize, String name);

    //修改员工
    public R<String> update(HttpServletRequest request, @RequestBody Employee employee);

    //根据信息查询员工
    public R<Employee> findById(@PathVariable Long id);
}
