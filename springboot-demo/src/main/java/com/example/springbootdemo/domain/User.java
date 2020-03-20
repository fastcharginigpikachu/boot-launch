package com.example.springbootdemo.domain;

import lombok.Data;

@Data//放在类之前，相当于添加了set，get，toString，equals，hashcode
public class User {
    private int age;//如果不想“一刀切”设置Data，可以在属性前注释@Setter/@Getter
    private String pwd;
    private String name;

    public User() {//保持好习惯，构造函数还是不要忘了
        super();
    }

    public User(int age, String pwd, String name) {
        super();
        this.age = age;
        this.pwd = pwd;
        this.name = name;
    }

}
