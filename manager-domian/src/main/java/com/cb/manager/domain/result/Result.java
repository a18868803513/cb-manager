/**
 * Copyright 2018 www.arbexpress.cn
 * <p>
 * All right reserved
 * <p>
 * Create on 2018/7/26 19:10
 */
package com.cb.manager.domain.result;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @File: Result
 * @Author: chenbo
 * @Date: 2018/7/26 19:10
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private boolean success;
    private String message;
    private T t;
    public static Result success(){
       return Result.builder().success(true).build();
    }
    public static<T> Result<T> success(T t){
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setT(t);
        return result;
    }
    public static Result fail(){
        return new Result();
    }
    public static Result fail(String message){
        return  Result.builder().message(message).build();
    }
}
