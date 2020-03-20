package com.example.springbootdemo.domain;

//自定义异常
public class MyException extends RuntimeException {//注意我们这里谈的不是程序中的异常，所以继承的是RuntimeException
    private int code;
    private String msg;

    public MyException(int code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
