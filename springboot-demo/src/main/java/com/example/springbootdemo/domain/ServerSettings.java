package com.example.springbootdemo.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//实体类的配置
//服务器配置
@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "test")//筛选前缀,则不用@Value，有隐藏了这一步（但是还是得映射一次的吧）
public class ServerSettings {
    //@Value("${appname}")//配置文件->类
    private String name;//名称
   // @Value("${domain}")
    private String domain;//域名

    public String getName() {
        return name;
    }

    public String getDomain() {
        return domain;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

}
