package com.cc.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.reggie.common.R;
import com.cc.reggie.entity.AddressBook;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface AddressBookService extends IService<AddressBook> {
    //新增地址
    public R<AddressBook> saveAddress(@RequestBody AddressBook addressBook);

    //设置默认地址
    public R<AddressBook> setDefault(@RequestBody AddressBook addressBook);

    //根据用户id查询地址列表
    public R get(@PathVariable Long id);

    //查询默认地址
    public R<AddressBook> getDefault();

    //查询地址列表
    public R<List<AddressBook>> list(AddressBook addressBook);

    //修改地址
    public R<String> update(@RequestBody AddressBook addressBook);

    //删除地址
    public R<String> deleteAddress(Long ids);

}
