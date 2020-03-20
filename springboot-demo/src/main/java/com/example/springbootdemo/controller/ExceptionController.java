package com.example.springbootdemo.controller;

import com.example.springbootdemo.domain.MyException;
import com.example.springbootdemo.domain.User;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//异常处理
@RestController
public class ExceptionController {
    @RequestMapping("/api/v1/test_ext")
    public Object index() {
        int a = 1/0;//异常
        return new User(11,"123456","zgh");
    }
    @RequestMapping("/api/v1/my_ext")
    public Object myExt() {
        throw new MyException(500,"myException");//抛异常就不用返回东西的！！！
    }
}
