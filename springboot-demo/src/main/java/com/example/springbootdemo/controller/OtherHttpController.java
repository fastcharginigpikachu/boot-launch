package com.example.springbootdemo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//测试http的post，delete，put请求
@RestController
public class OtherHttpController {
    private Map<String,Object> parems = new HashMap<>();

    /**
     * 功能：测试PostMapping
     * @param pwd
     * @param id
     * @return
     */
    @PostMapping("/v1/login")//提交
    public Object login(String id,String pwd) {
        parems.clear();
        parems.put("id",id);
        parems.put("pwd",pwd);
        if (pwd.equals("123456"))
            return parems;
        else return "wrong pwd";
    }

    @PutMapping("/v1/put")//更新修改
    public Object put(String id) {
    /*    if ((parems.get("pwd")==pwd)&&(parems.get("id")==oldId)) {
            parems.put("id",newId);
            return parems;
        } else {
            return "wrong id or pwd\n"+parems;
        }//没存在数据库，无记忆性
    */
    parems.clear();
    parems.put("id",id);
    return parems;
    }

    @DeleteMapping("/v1/del")//删除
    public Object del(String id) {
        parems.clear();
        return parems;
    }
}
