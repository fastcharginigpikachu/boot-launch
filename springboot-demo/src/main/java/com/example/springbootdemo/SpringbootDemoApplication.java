package com.example.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
// 此注解的底层已经被注解，所以是多种注解的封装：注解已经被注解->封装注解
//所以，找到底层代码，可以改变封住效果
//上面的注解相当于以下三个：
@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan//服务启动时扫描
@ServletComponentScan//扫描监听器过滤器
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

    //启动配置
    //必须类是被@SpringBootConfiguration
    @Bean//记住，在.java启动类中的配置函数
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件最大
        factory.setMaxFileSize(DataSize.of(10, DataUnit.MEGABYTES)); //注意这里数据大小的写法,这里在代码中直接写配置的，非常不好。“硬配置”应该避免
        // 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.of(100,DataUnit.MEGABYTES));

        return factory.createMultipartConfig();

    }
}
