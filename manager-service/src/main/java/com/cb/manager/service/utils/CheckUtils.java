/**
 * Copyright 2018 www.arbexpress.cn
 * <p>
 * All right reserved
 * <p>
 * Create on 2018/7/26 19:44
 */
package com.cb.manager.service.utils;


import com.cb.manager.service.Exception.ManagerException;
import org.apache.commons.lang3.StringUtils;

/**
 * @File: CheckUtils
 * @Author: chenbo
 * @Date: 2018/7/26 19:44
 * @Description: 检验工具类
 */
public class CheckUtils {
    private static CheckUtils checkUtils = new CheckUtils();

    public static CheckUtils checkString(String param,String msg){
        if (StringUtils.isBlank(param)){
            throw new ManagerException("1001",msg);
        }
        return checkUtils;
    }

    public static CheckUtils checkNull(Object obj,String msg){
        if (null == obj){
            throw new ManagerException("1001",msg);
        }
        return checkUtils;
    }
    public static CheckUtils check(Boolean bol,String msg){
        if (!bol){
            throw new ManagerException("1001",msg);
        }
        return checkUtils;
    }
}
