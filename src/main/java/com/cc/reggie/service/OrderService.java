package com.cc.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.reggie.entity.Orders;

public interface OrderService extends IService<Orders> {
    //用户下单
    public void submit(Orders orders);

    //购物车添加
    public void orderAgain(long id);
}
