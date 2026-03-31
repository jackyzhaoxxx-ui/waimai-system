package com.cc.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.reggie.common.R;
import com.cc.reggie.entity.OrderDetail;
import com.cc.reggie.entity.Orders;
import com.cc.reggie.mapper.OrderDetailMapper;
import com.cc.reggie.service.OrderDetailService;
import com.cc.reggie.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 郑梓聪
 * @description 订单详情控制器
 * @date 2022-06-23
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    /**
     * 用户下单
     *
     * @param orders
     */
    @RequestMapping("/submit")
    public R<String> submit(@RequestBody Orders orders) {
        return orderDetailService.submit(orders);
    }

    /**
     * 分页查询订单详情
     *
     * @param page
     * @param pageSize
     * @param number
     * @param beginTime
     * @param endTime
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String number, String beginTime, String endTime) {
        return orderDetailService.page(page, pageSize, number, beginTime, endTime);
    }

    /**
     * 更新状态
     *
     * @param orders
     * @return
     */
    @PutMapping
    public R<String> update(@RequestBody Orders orders) {
        return orderDetailService.updateOrderDetail(orders);
    }


    /**
     * 客户端点击再来一单
     *
     * @param map
     * @return
     */
    @PostMapping("/again")
    /**
     * 前端点击再来一单是直接跳转到购物车的，所以为了避免数据有问题，再跳转之前我们需要把购物车的数据给清除
     * ①通过orderId获取订单明细
     * ②把订单明细的数据的数据塞到购物车表中，不过在此之前要先把购物车表中的数据给清除(清除的是当前登录用户的购物车表中的数据)，
     * 不然就会导致再来一单的数据有问题；
     * (这样可能会影响用户体验，但是对于外卖来说，用户体验的影响不是很大，电商项目就不能这么干了)
     */
    public R<String> again(@RequestBody Map<String, String> map) {
        return orderDetailService.again(map);
    }

    //抽离的一个方法，通过订单id查询订单明细，得到一个订单明细的集合
    //这里抽离出来是为了避免在stream中遍历的时候直接使用构造条件来查询导致eq叠加，从而导致后面查询的数据都是null
    public List<OrderDetail> getOrderDetailListByOrderId(Long orderId) {
        return orderDetailMapper.selectList(new LambdaQueryWrapper<OrderDetail>().eq(OrderDetail::getOrderId, orderId));
    }
//    /**
//     * 查询用户订购过的订单
//     * @param page
//     * @param pageSize
//     * @return
//     */
//    @GetMapping("/userPage")
//    public R<Page> userPage(int page, int pageSize){
//        log.info("page={}, pageSize={}",page, pageSize);
//        Page<Orders> pageInfo = new Page<>(page, pageSize);
//        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.orderByDesc(Orders::getOrderTime);
//        orderService.page(pageInfo,queryWrapper);
//        return R.success(pageInfo);
//    }

    /**
     * 用户端展示自己的订单分页查询
     * 正确方法:直接从分页对象中获取订单id就行，问题大大简化了......
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/userPage")
    public R<Page> page(int page, int pageSize) {
        return orderDetailService.page(page, pageSize);
    }
}
