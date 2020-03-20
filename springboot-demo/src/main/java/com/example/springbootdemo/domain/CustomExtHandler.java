package com.example.springbootdemo.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//相当于catch的部分，在Controller类外部的Handle类，catchController类抛出的各种异常
@ControllerAdvice//注释为异常处理类
@RestControllerAdvice//也可以返回Json
public class CustomExtHandler {
    private static final Logger LOG = LoggerFactory.getLogger(CustomExtHandler.class);//将本类中处理的问题记录到日志中

    @ExceptionHandler(value = Exception.class)//接收和处理的异常声明
    @ResponseBody//注释为“返回Json格式”到前端，给前端看
    //所有要给前端返回的东西，基本都是Json，都需要这条注释
    Object handleException(Exception e, HttpServletRequest request) {//传如各种异常
        LOG.error("url {},msg {}",request.getRequestURI(),e.getMessage());//写入日志

        Map<String, Object> map = new HashMap<>();
        map.put("code",100);
        map.put("msg",e.getMessage());
        map.put("url",request.getRequestURI());
        return map;//要给前端返回Json格式，而不是一个View，所以要在前面注释
    }

    @ExceptionHandler(value = MyException.class)
    Object handleMyException(MyException e,HttpServletRequest request) {
        /*ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error.html");//设置异常时要跳转的页面
        modelAndView.addObject("msg",e.getMessage());
        return modelAndView;
         */

        //返回Json数据
        Map<String, Object> map = new HashMap<>();
        map.put("code",404);
        map.put("msg",e.getMessage());
        map.put("url",request.getRequestURI());
        return map;
    }


}
