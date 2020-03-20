package com.example.springbootdemo.listener;

import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

//@WebListener暂时注释掉
public class requestListener implements ServletRequestListener {//注意加载时间，主要做资源加载用
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {//请求离开
        System.out.println("----requestDestroyed----");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {//请求进入
        System.out.println("----requestInitialized-----");
    }


}
