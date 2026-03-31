package com.cc.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.reggie.common.BaseContext;
import com.cc.reggie.common.R;
import com.cc.reggie.entity.ShoppingCart;
import com.cc.reggie.mapper.ShoppingCartMapper;
import com.cc.reggie.service.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

/**
 * @author 郑梓聪
 * @description 购物车服务实现类
 * @date 2022-06-22
 */
@Service
@Slf4j
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {

    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * 添加购物车商品
     *
     * @param shoppingCart
     * @return
     */
    @Transactional
    @Override
    public R<ShoppingCart> shoppingCartadd(@RequestBody ShoppingCart shoppingCart) {
        log.info("购物车数据: {}", shoppingCart);

        //设置用户id,指定用户添加购物车
        Long currentId = BaseContext.getCurrentId();
        shoppingCart.setUserId(currentId);

        //查询当前菜品或者套餐是否已经存在购物车中
        Long dishId = shoppingCart.getDishId();
        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId, currentId);

        if (dishId != null) {
            //添加到购物车的是菜品
            queryWrapper.eq(ShoppingCart::getDishId, dishId);
        } else {
            //添加到购物车的是套餐
            queryWrapper.eq(ShoppingCart::getSetmealId, shoppingCart.getSetmealId());
        }

        //SQL: select * from shopping_cart where user_id = #{currentId} and (dish_id = #{dishId} or setmeal_id = #{setmealId})
        ShoppingCart cartServiceOne = shoppingCartService.getOne(queryWrapper);

        //如果购物车中已经存在该菜品或者套餐,则只修改数量
        if (cartServiceOne != null) {
            //如果存在,则更新数量
            Integer number = cartServiceOne.getNumber();
            cartServiceOne.setNumber(number + 1);
            shoppingCart.setCreateTime(LocalDateTime.now());
            shoppingCartService.updateById(cartServiceOne);
        } else {
            //如果不存在,则添加到购物车
            shoppingCart.setNumber(1);
            shoppingCart.setCreateTime(LocalDateTime.now());
            shoppingCartService.save(shoppingCart);
            cartServiceOne = shoppingCart;
        }
        return R.success(cartServiceOne);
    }

    /**
     * 清空购物车
     */
    @Transactional
    @Override
    public void clean() {
        //设置用户id，指定当前是哪个用户的购物车数据
        Long currentId = BaseContext.getCurrentId();
        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId, currentId);
        // DELETE FROM shopping_cart WHERE user_id=?
        shoppingCartService.remove(queryWrapper);
        //用下面这句user_id查不到，查的是id DELETE FROM shopping_cart WHERE id=?
//        shoppingCartService.removeById(currentId);
    }

    /**
     * 减少购物车商品数量
     *
     * @param shoppingCart
     * @return
     */
    @Transactional
    @Override
    public R<ShoppingCart> sub(ShoppingCart shoppingCart) {
        Long setmealId = shoppingCart.getSetmealId();
        Long dishId = shoppingCart.getDishId();
        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId, BaseContext.getCurrentId());

        if (setmealId != null) {
            queryWrapper.eq(ShoppingCart::getSetmealId, setmealId);
        } else {
            queryWrapper.eq(ShoppingCart::getDishId, dishId);
        }
        ShoppingCart one = shoppingCartService.getOne(queryWrapper);
        Integer number = one.getNumber();
        if (number == 1) {
            shoppingCartService.remove(queryWrapper);
        } else {
            one.setNumber(number - 1);
            shoppingCartService.updateById(one);
        }

        return R.success(one);
    }
}
