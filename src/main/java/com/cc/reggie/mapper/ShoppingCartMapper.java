package com.cc.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cc.reggie.entity.ShoppingCart;
import com.cc.reggie.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {
}
