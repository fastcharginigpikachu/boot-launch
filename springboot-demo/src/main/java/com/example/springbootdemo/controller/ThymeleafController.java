package com.example.springbootdemo.controller;

import com.example.springbootdemo.domain.ServerSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {
    @Autowired
    private ServerSettings settings;
    @GetMapping("hello")
    public String index() {//注意看这里的返回值
        return "index";//配置文件已经设置好路径和后缀.配置文件只能写一种
    }
    @GetMapping("info")
    public String admin(ModelMap modelMap) {
        modelMap.addAttribute("setting",settings);
        return "admin/info";//不用加后缀
    }
}
