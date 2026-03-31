package com.cc.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.reggie.common.R;
import com.cc.reggie.entity.User;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 移动端用户业务层
 *
 * @author 郑梓聪
 * @date 2022-06-23
 */
public interface UserService extends IService<User> {
    //发送验证码
    public R<String> sendMsg(@RequestBody User user, HttpSession session);

    //用户登录
    public R<User> login(@RequestBody Map map, HttpSession session);

    //退出登录
    public R<String> logout(HttpServletRequest request);


}
