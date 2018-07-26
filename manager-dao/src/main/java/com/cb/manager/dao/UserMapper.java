/**
 * Copyright 2018 www.arbexpress.cn
 * <p>
 * All right reserved
 * <p>
 * Create on 2018/7/25 23:21
 */
package com.cb.manager.dao;

import com.cb.manager.config.MyMapper;
import com.cb.manager.domain.DO.UserDO;
import com.cb.manager.domain.param.RegisterParam;
import org.apache.ibatis.annotations.Select;

/**
 * @File: UserMapper
 * @Author: chenbo
 * @Date: 2018/7/25 23:21
 * @Description: 用户
 */
public interface UserMapper extends MyMapper<UserDO> {

    /**
     * 通过username or email 查询用户是
     * @param param
     * @return
     */
    @Select("select * from tb_user where username = #{username} or email = #{email}")
    UserDO selectUserByUsernameOrEmail(RegisterParam param);
}
