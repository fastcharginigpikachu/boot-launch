package com.example.springbootdemo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.crypto.Data;
import java.util.Date;
//Json是前后端交流的通道，用Json实现前后端分离的桥接
public class User_Json {

    private int age;

    @JsonIgnore//返回时隐藏
    private String pwd;//返回Json时，不能返回给前端密码

    @JsonProperty("account")//起别名，也有隐藏重要信息的作用，对外暴露得尽可能少
    private String phone;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale = "zh",timezone = "GMT+8")//日期格式，语言，时区
    private Date createTime;
    //@JsonInclude(JsonInclude.Include.NON_NULL)空字段不返回

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public User_Json() {
        super();
    }

    public User_Json(int age, String pwd, String phone, Date createTime) {
        super();
        this.age = age;
        this.pwd = pwd;
        this.phone = phone;
        this.createTime = createTime;
    }


}
