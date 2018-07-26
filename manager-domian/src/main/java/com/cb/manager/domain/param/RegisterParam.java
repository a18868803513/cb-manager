/**
 * Copyright 2018 www.arbexpress.cn
 * <p>
 * All right reserved
 * <p>
 * Create on 2018/7/26 19:26
 */
package com.cb.manager.domain.param;


import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @File: RegisterParam
 * @Author: chenbo
 * @Date: 2018/7/26 19:26
 * @Description: 注册入参
 */
@Data
public class RegisterParam {
    @NotBlank(message = "用户名不能为空")
    @Length(min = 6,max = 12,message = "用户名为6-12位")
    private String username;
    @NotBlank(message = "密码不能为空")
    @Length(min = 6,max = 12,message = "密码为6-12位")
    private String password;
    @NotBlank(message = "确认密码不能为空")
    @Length(min = 6,max = 12,message = "确认密码为6-12位")
    private String passwordAgain;
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;
}
