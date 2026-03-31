package com.cc.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cc.reggie.entity.Orders;
import com.cc.reggie.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.core.annotation.Order;

@Mapper
public interface OrderMapper extends BaseMapper<Orders> {
}
