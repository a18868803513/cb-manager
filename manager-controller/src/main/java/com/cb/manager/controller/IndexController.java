/**
 * Copyright 2018 www.arbexpress.cn
 * <p>
 * All right reserved
 * <p>
 * Create on 2018/7/25 23:11
 */
package com.cb.manager.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @File: IndexController
 * @Author: chenbo
 * @Date: 2018/7/25 23:11
 * @Description:
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "index.html";
    }
}
