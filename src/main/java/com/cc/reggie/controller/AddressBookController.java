package com.cc.reggie.controller;

import com.cc.reggie.common.R;
import com.cc.reggie.entity.AddressBook;
import com.cc.reggie.service.AddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 地址簿管理
 */
@Slf4j
@RestController
@RequestMapping("/addressBook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    /**
     * 新增地址
     *
     * @param addressBook
     * @return
     */
    @PostMapping
    public R<AddressBook> save(@RequestBody AddressBook addressBook) {

        return addressBookService.saveAddress(addressBook);
    }

    /**
     * 设置默认地址
     * @param addressBook
     * @return
     */
    @PutMapping("default")
    public R<AddressBook> setDefault(@RequestBody AddressBook addressBook) {
        return addressBookService.setDefault(addressBook);
    }

    /**
     * 根据用户id查询地址列表
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R get(@PathVariable Long id) {
        return addressBookService.get(id);
    }

    /**
     * 查询默认地址
     * @return
     */
    @GetMapping("default")
    public R<AddressBook> getDefault() {
        return addressBookService.getDefault();
    }

    /**
     * 查询地址列表
     * @param addressBook
     * @return
     */
    @GetMapping("/list")
    public R<List<AddressBook>> list(AddressBook addressBook) {
        return addressBookService.list(addressBook);
    }

    /**
     * 修改收货地址
     *
     * @param addressBook
     * @return
     */
    @PutMapping
    public R<String> update(@RequestBody AddressBook addressBook) {
        return addressBookService.update(addressBook);
    }

    /**
     * 删除地址
     * 巨坑：
     * 不用@RequestBody，因为前端传过来的是一个数组，而不是一个对象
     *
     * @param
     * @return
     */
    @DeleteMapping
    public R<String> delete(Long ids) {
        return addressBookService.deleteAddress(ids);
    }
}
