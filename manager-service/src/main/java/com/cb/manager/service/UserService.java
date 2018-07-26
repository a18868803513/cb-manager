/**
 * Copyright 2018 www.arbexpress.cn
 * <p>
 * All right reserved
 * <p>
 * Create on 2018/7/25 23:19
 */
package com.cb.manager.service;

import com.cb.manager.domain.DO.UserDO;
import com.cb.manager.domain.param.RegisterParam;

/**
 * @File: UserService
 * @Author: chenbo
 * @Date: 2018/7/25 23:19
 * @Description: 用户
 */
public interface UserService {
    UserDO get();

    /**
     * 用户注册
     * @param param 注册入参
     * @return
     */
    UserDO register(RegisterParam param);
}
