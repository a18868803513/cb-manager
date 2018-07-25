/**
 * Copyright 2018 www.arbexpress.cn
 * <p>
 * All right reserved
 * <p>
 * Create on 2018/7/25 23:15
 */
package com.cb.manager.controller;


import com.cb.manager.domain.DO.UserDO;
import com.cb.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @File: UserController
 * @Author: chenbo
 * @Date: 2018/7/25 23:15
 * @Description:
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public UserDO get(){
        return userService.get();
    }
}
