package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //一个注解顶下面3个
@MapperScan("com.example.demo.mapper")
public class XdclassApplication  {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(XdclassApplication.class, args);
    }
    

}