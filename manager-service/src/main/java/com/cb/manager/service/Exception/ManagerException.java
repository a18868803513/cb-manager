/**
 * Copyright 2018 www.arbexpress.cn
 * <p>
 * All right reserved
 * <p>
 * Create on 2018/7/26 20:22
 */
package com.cb.manager.service.Exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @File: ManagerException
 * @Author: chenbo
 * @Date: 2018/7/26 20:22
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManagerException extends RuntimeException {
    private String code;
    private String msd;
}
