package com.example.springbootdemo.controller;

import com.example.springbootdemo.domain.ServerSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {


    @Autowired
    private ServerSettings setting;


    @GetMapping("hello")
    public String index(ModelMap modelMap){

        modelMap.addAttribute("settings", setting);//html调用时使用的名字

        return "fm/index";  //不用加后缀，在配置文件里面已经指定了后缀
    }




}