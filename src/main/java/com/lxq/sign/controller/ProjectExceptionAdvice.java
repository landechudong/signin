package com.lxq.sign.controller;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result getException(){
        System.out.println(Exception.class);
        return new Result(Code.SYSTEM_UNKNOW_ERR,false,"请在开始周和结束周输入正确的格式");
    }

//    @ExceptionHandler(Exception.class)
//    public Result getEx(){
//        System.out.println(Exception.class);
//        return new Result(Code.SYSTEM_UNKNOW_ERR,false,"请输入正确的格式!!");
//    }


}
