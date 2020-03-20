package com.example.springbootdemo.domain;

import java.io.Serializable;

public class JsonData implements Serializable {//可序列化
    private static final long serialVersionUID = 1L;

    private int code;//状态码 0->success -1->failed
    private Object data;//结果

    public JsonData(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }
}
