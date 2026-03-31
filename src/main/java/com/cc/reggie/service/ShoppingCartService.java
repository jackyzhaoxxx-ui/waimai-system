package com.cc.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.reggie.common.R;
import com.cc.reggie.entity.ShoppingCart;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 郑梓聪
 * @description 购物车服务接口
 * @date 2022-06-22
 */
public interface ShoppingCartService extends IService<ShoppingCart> {
    //添加购物车商品
    public R<ShoppingCart> shoppingCartadd(@RequestBody ShoppingCart shoppingCart);

    //清空购物车
    void clean();

    //减少购物车商品数量
    R<ShoppingCart> sub(ShoppingCart shoppingCart);
}
