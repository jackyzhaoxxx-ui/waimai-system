package com.cc.reggie.controller;

import com.cc.reggie.common.R;
import com.cc.reggie.entity.Orders;
import com.cc.reggie.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 用户下单
     *
     * @param order
     * @return
     */
    @PostMapping("/submit")
    public R<String> submit(@RequestBody Orders order) {
        log.info("下单数据: {}", order);
        orderService.submit(order);
        return R.success("下单成功!");
    }


}
