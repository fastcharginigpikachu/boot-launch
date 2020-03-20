package com.example.springbootdemo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CustomContextListener implements ServletContextListener {//最先加载，最后销毁，注意加载时间，主要做统计用
    @Override
    public void contextInitialized(ServletContextEvent sce) {//加载资源
        System.out.println("---contextlistener initial----");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("---contextlistener destroyed----");
    }
}
