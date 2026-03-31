package com.cc.reggie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.reggie.common.R;
import com.cc.reggie.entity.OrderDetail;
import com.cc.reggie.entity.Orders;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * @author 郑梓聪
 * @description 订单详情业务接口
 * @date 2022-06-23
 */
public interface OrderDetailService extends IService<OrderDetail> {
    //用户下单
    public R<String> submit(@RequestBody Orders orders);

    //分页查询订单详情
    public R<Page> page(int page, int pageSize, String number, String beginTime, String endTime);

    //更新状态
    public R<String> updateOrderDetail(@RequestBody Orders orders);

    //再来一单
    public R<String> again(@RequestBody Map<String, String> map);

    //通过订单id查询订单明细，得到一个订单明细的集合
    public List<OrderDetail> getOrderDetailListByOrderId(Long orderId);

    //订单分页
    public R<Page> page(int page, int pageSize);

}
