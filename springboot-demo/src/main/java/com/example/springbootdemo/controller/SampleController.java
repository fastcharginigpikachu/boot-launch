package com.example.springbootdemo.controller;

import com.example.springbootdemo.domain.User_Json;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController//相当于所有函数都是@ResponseBody，并且@Controller
public class SampleController {
    @RequestMapping("/")
    @ResponseBody//结果以Json返回
    String home() {
        return "HelloWorld";
    }

    @RequestMapping("/test")
    //不加1responbady则会报错，因为不知道要返回什么
    public Map<String,String> testMap () {
        Map<String,String> map = new HashMap<>();
        map.put("name","zgh");
        return map;
    }

    @GetMapping("/testjson")
    public Object testJson () {
        return new User_Json(10,"123456","138888",new Date());
    }

    @GetMapping("/test/home")
    public String homeTest() {
        return "test api";
    }
}
