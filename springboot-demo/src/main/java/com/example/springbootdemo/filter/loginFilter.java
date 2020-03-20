package com.example.springbootdemo.filter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//场景：权限控制，用户登录
//暂时注释掉
//@WebFilter(urlPatterns = "/api",filterName = "loginFilter")//标记为filter,注解出触发条件    servlet的注解，不是springboot的
public class loginFilter implements Filter {//实现三个方法

    //容器加载的时候调用
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init login Filter");
    }

    //请求被拦截是调用过滤器
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("do loginFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;//一般都是HTTP请求和回应，形参里不能写，但是这里要强制转换
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //这后面可以得到用户名密码，查询数据库，看是否符合
        String username = request.getParameter("username");
        if ("zgh".equals(username)) {
            filterChain.doFilter(servletRequest, servletResponse);//放行！！！，意思就是“允许这个请求和回复”通过
        } else {
            return;
            //response.sendRedirect("(.*?)");//不通过，拦截，跳转到其他页面,一般自定义一个“提示出错的页面”
            //所以这个Filter适合非前后端分离的，可以方便地进行页面跳转。
            //对于Springboot前后端分离的，有另一种“拦截器”
        }


    }
    //容器被销毁的时候调用
    @Override

    public void destroy() {
        System.out.println("destroy loginFilter");
    }
}
