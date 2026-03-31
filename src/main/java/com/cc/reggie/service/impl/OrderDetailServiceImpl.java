package com.cc.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.reggie.common.BaseContext;
import com.cc.reggie.common.R;
import com.cc.reggie.dto.OrdersDto;
import com.cc.reggie.entity.OrderDetail;
import com.cc.reggie.entity.Orders;
import com.cc.reggie.mapper.OrderDetailMapper;
import com.cc.reggie.service.OrderDetailService;
import com.cc.reggie.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 郑梓聪
 * @description 订单详情服务接口实现类
 * @date 2022-06-23
 */
@Service
@Slf4j
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private OrderService orderService;

    @Override
    public R<String> submit(@RequestBody Orders orders) {
        log.info("下单数据: {}", orders);
        orderService.submit(orders);
        return R.success("下单成功!");
    }

    @Override
    public R<Page> page(int page, int pageSize, String number, String beginTime, String endTime) {
        log.info("page={}, pageSize={}, number={}, beginTime={}, endTime={}", page, pageSize, number, beginTime, endTime);
        //构造分页构造器
        Page<Orders> pageInfo = new Page<>(page, pageSize);
        //构造条件构造器
        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.like(number != null, Orders::getNumber, number)
                .ge(StringUtils.isNotEmpty(beginTime), Orders::getOrderTime, beginTime)
                .le(StringUtils.isNotEmpty(endTime), Orders::getOrderTime, endTime);

        //添加排序条件
        queryWrapper.orderByDesc(Orders::getOrderTime);

        //执行查询
        orderService.page(pageInfo, queryWrapper);

        return R.success(pageInfo);
    }

    /**
     * 更新状态
     *
     * @param orders
     * @return
     */
    @Transactional
    @Override
    public R<String> updateOrderDetail(Orders orders) {
        //判断传入参数是否合法
        Long orderId = orders.getId();
        Integer status = orders.getStatus();

        if (orderId == null || status == null) {
            return R.error("传入信息不合法");
        }

        log.info("订单数据{}", orders);
        //SQL: UPDATE orders SET status=? WHERE id=?
        orderService.updateById(orders);
        return R.success("订单修改状态成功");
    }

    /**
     * 再来一单
     *
     * @param map
     * @return
     */
    @Transactional
    @Override
    public R<String> again(Map<String, String> map) {
        log.info("订单id:{}", map);
        String ids = map.get("id");
        long id = Long.parseLong(ids);
        orderService.orderAgain(id);
        return R.success("再来一单");
    }

    /**
     * 抽离的一个方法，通过订单id查询订单明细，得到一个订单明细的集合
     * 这里抽离出来是为了避免在stream中遍历的时候直接使用构造条件来查询导致eq叠加，从而导致后面查询的数据都是null
     *
     * @param orderId
     * @return
     */
    @Transactional
    @Override
    public List<OrderDetail> getOrderDetailListByOrderId(Long orderId) {
        LambdaQueryWrapper<OrderDetail> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderDetail::getOrderId, orderId);
        List<OrderDetail> orderDetailList = orderDetailService.list(queryWrapper);
        return orderDetailList;
    }

    /**
     * 订单分页
     *
     * @param page
     * @param pageSize
     * @return
     */
    @Transactional
    @Override
    public R<Page> page(int page, int pageSize) {
        //分页构造器对象
        Page<Orders> pageInfo = new Page<>(page, pageSize);
        Page<OrdersDto> pageDto = new Page<>(page, pageSize);
        //构造条件查询对象
        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Orders::getUserId, BaseContext.getCurrentId());
        //这里是直接把当前用户分页的全部结果查询出来，要添加用户id作为查询条件，否则会出现用户可以查询到其他用户的订单情况
        //添加排序条件，根据更新时间降序排列
        queryWrapper.orderByDesc(Orders::getOrderTime);
        orderService.page(pageInfo, queryWrapper);

        //通过OrderId查询对应的OrderDetail
        LambdaQueryWrapper<OrderDetail> queryWrapper2 = new LambdaQueryWrapper<>();

        //对OrderDto进行需要的属性赋值
        List<Orders> records = pageInfo.getRecords();
        List<OrdersDto> orderDtoList = records.stream().map((item) -> {
            OrdersDto orderDto = new OrdersDto();
            //此时的orderDto对象里面orderDetails属性还是空 下面准备为它赋值
            Long orderId = item.getId();//获取订单id
            List<OrderDetail> orderDetailList = this.getOrderDetailListByOrderId(orderId);
            BeanUtils.copyProperties(item, orderDto);
            //对orderDto进行OrderDetails属性的赋值
            orderDto.setOrderDetails(orderDetailList);
            return orderDto;
        }).collect(Collectors.toList());

        //使用dto的分页有点难度.....需要重点掌握
        BeanUtils.copyProperties(pageInfo, pageDto, "records");
        pageDto.setRecords(orderDtoList);
        return R.success(pageDto);
    }
}
