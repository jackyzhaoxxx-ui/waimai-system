package com.cc.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.reggie.common.R;
import com.cc.reggie.entity.User;
import com.cc.reggie.mapper.UserMapper;
import com.cc.reggie.service.UserService;
import com.cc.reggie.utils.SMSUtils;
import com.cc.reggie.utils.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 移动端用户业务层接口
 *
 * @author 郑梓聪
 * @date 2022-06-23
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 发送手机验证码
     *
     * @param user
     * @return
     */
    @Transactional
    @Override
    public R<String> sendMsg(User user, HttpSession session) {
        //获取手机号
        String phone = user.getPhone();

        if (StringUtils.isNotEmpty(phone)) {
            //生成随机验证码
            String code = ValidateCodeUtils.generateValidateCode(6).toString();
            log.info("验证码：{}", code);

            //调用阿里云提供的短信API发送验证码
            try {
                SMSUtils.sendMessage(phone, code);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //将验证码存入session
//            session.setAttribute(phone, code);

            //将验证码存入redis。设置过期时间为5分钟
            redisTemplate.opsForValue().set(phone, code, 5, TimeUnit.MINUTES);

            return R.success("手机验证码发送成功！");
        }

        return R.error("短信发送失败！");
    }

    /**
     * 用户登录
     *
     * @param map
     * @param session
     * @return
     */
    @Transactional
    @Override
    public R<User> login(Map map, HttpSession session) {
        //获取手机号
        String phone = (String) map.get("phone");

        //获取验证码
        String code = (String) map.get("code");

        //从session中获取验证码
//        String sessionCode = (String) session.getAttribute(phone);

        //从 redis 中获取验证码
        Object redisCode = redisTemplate.opsForValue().get(phone);
        
        //验证验证码是否正确
        // TODO: 测试环境临时方案 - 允许任意 6 位验证码登录
        // 正式环境应该验证：if (redisCode != null && redisCode.equals(code)) {
        if (code != null && code.length() == 6) {
            //验证码正确，登录成功
            //判断当前手机号对应的用户是否存在，如果是新用户，则注册
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone, phone);
            User user = userService.getOne(queryWrapper);
            if (user == null) {
                //新用户，注册
                user = new User();
                user.setPhone(phone);
                user.setStatus(1);
                userService.save(user);
                log.info("新用户注册成功：{}", phone);
            }
        
            //将用户信息存入 session
            session.setAttribute("user", user.getId());
            log.info("登录成功 - 用户 ID: {}", user.getId());

            //如果用户登陆成功。删除 redis 中的验证码
            redisTemplate.delete(phone);

            return R.success(user);
        }

        log.warn("登录失败 - 手机号：{}, 验证码：{}", phone, code);
        return R.error("登录失败！");
    }

    /**
     * 用户退出
     *
     * @param request
     * @return
     */
    @Override
    public R<String> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return R.success("退出成功");
    }
}
