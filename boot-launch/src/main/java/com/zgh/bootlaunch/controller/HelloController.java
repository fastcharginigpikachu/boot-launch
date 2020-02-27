package com.zgh.bootlaunch.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")//设置到url的映射！
    public String hello() {
        return "HelloWorld";
    }
}
