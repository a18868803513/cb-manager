package com.cb.manager; /**
 * Copyright 2018 www.arbexpress.cn
 * <p>
 * All right reserved
 * <p>
 * Create on 2018/7/25 23:11
 */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @File: Application
 * @Author: chenbo
 * @Date: 2018/7/25 23:11
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.cb.manager.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
