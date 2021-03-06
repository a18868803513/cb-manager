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
import com.cb.manager.domain.param.RegisterParam;
import com.cb.manager.service.UserService;
import com.cb.manager.service.utils.CheckUtils;
import com.cb.manager.service.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

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

    /**
     * 用户注册
     * @param param 注册入参
     * @return
     */
    @Override
    public UserDO register(RegisterParam param) {
        CheckUtils.checkNull(userMapper.selectUserByUsernameOrEmail(param),"用户名或邮箱已注册")
        .check(Objects.equals(param.getPassword(),param.getPasswordAgain()),"确认密码不一致");
        UserDO userDO = UserDO.builder().username(param.getUsername()).password(param.getPassword()).
                createTime(DateUtil.getCurrentDateTime()).updateTime(DateUtil.getCurrentDateTime()).build();
        userMapper.insert(userDO);
        return userDO;
    }
}
