/**
 * Copyright 2018 www.arbexpress.cn
 * <p>
 * All right reserved
 * <p>
 * Create on 2018/7/25 23:22
 */
package com.cb.manager.service.impl;


import com.cb.manager.dao.UserMapper;
import com.cb.manager.domain.DO.UserDO;
import com.cb.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @File: UserServiceImpl
 * @Author: chenbo
 * @Date: 2018/7/25 23:22
 * @Description: 用户
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDO get() {
        return userMapper.selectOne(UserDO.builder().username("cb").build());
    }
}
