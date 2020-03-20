package com.example.springbootdemo.inpterceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//自定义拦截器，实现接口
public class TwoInterceptor implements HandlerInterceptor {
    //进入controller方法之前，校验，查权限等操作
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("TwoInterceptor----->prehandler");
        //  String token = request.getParameter("access_token");
        //  response.getWriter().println("提示用户是否通过");

        return HandlerInterceptor.super.preHandle(request,response,handler);
    }
    //调用完controller之后，视图渲染之前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("TwoInterceptor----->posthandler");
        HandlerInterceptor.super.postHandle(request,response,handler,modelAndView);
    }
    //整个完成之后，通常用于资源清理
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("TwoInterceptor----->afterhandler");
        HandlerInterceptor.super.afterCompletion(request,response,handler,ex);
    }
}
