package com.example.demo.domain;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private String phone;
    private int age;
    private Date creatTime;

    public User(int id, String name, String phone, int age, Date creatTime) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.creatTime = creatTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}
