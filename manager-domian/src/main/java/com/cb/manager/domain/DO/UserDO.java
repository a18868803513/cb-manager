/**
 * Copyright 2018 www.arbexpress.cn
 * <p>
 * All right reserved
 * <p>
 * Create on 2018/7/25 23:17
 */
package com.cb.manager.domain.DO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @File: UserDO
 * @Author: chenbo
 * @Date: 2018/7/25 23:17
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_user")
public class UserDO {
    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;
    /**
     * 密码
     */
    @Column(name = "password")
    private String password;
    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;
    /**
     * 0:未激活;1:已激活
     */
    @Column(name = "activated")
    private Integer activated;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String createTime;
    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private String updateTime;
}
