package com.example.springbootdemo.inpterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//拦截器的注册添加
@Configuration//配置文件中注册拦截器
public class CusttomWebMVCConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/api2/*/**");//添加拦截器列表，和拦截目标
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/api2/*/**");//最后用**是因为可能时文件名字+后缀的
        //顺序：prehandler是队列，posthandler和afterhandler是栈！先调用，后执行，也就后结束，很合理！
    }
}
/*
注意：Interceptor和Filter区别：这里也涉及Springboot的思想
Filter基于函数回调 doFilter，而Interceptor基于面向切片编程（AOP）
Filter只在Servle前后起作用，而Interceptor能够深入到方法前后，抛出异常前后
Filter依赖于Servlet容器（Web应用），而Interceptor不依赖容器可用于多种环境中
在接口调用的生命周期中，Filter只有容器初始化是调用一次，而Interceptor可以多次调用
执行顺序：过滤前-拦截前-action-拦截后-过滤后
 */
