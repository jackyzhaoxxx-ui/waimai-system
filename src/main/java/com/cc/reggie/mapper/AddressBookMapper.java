package com.cc.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cc.reggie.entity.AddressBook;
import com.cc.reggie.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressBookMapper extends BaseMapper<AddressBook> {
}
