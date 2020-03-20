package com.example.springbootdemo.controller;

import com.example.springbootdemo.domain.JsonData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller//一般来说，contoller下面的都是控制类，都要注释controller
//但是这个不涉及http网页部分，所以不必RestController？
//用于控制resources和static文件夹以外的资源
//而那三个文件夹下的资源，相对路径访问即可


@PropertySource("classpath:application.properties")//为这个类引入配置文件，配合属性前的@Value,也可以再写一个.properties文件
public class FileController {

    //测试
    @RequestMapping("/api/v1/gopage")//将网址与非静态资源建立连接
    public Object index() {
        return "index";
    }


    //文件上传功能——获取上传的文件
    @Value("${web.file.path}")//注意格式，字符串不要带引号，其他照搬
    private String filePath ;//只能是普通String！！！没有static 没有final
    @RequestMapping(value = "/upload")
    @ResponseBody
    private JsonData upload(@RequestParam("head_img") MultipartFile file, HttpServletRequest request) {//框架因为浏览器的访问而调用本函数，所以参数从浏览器端得来，一个请求，一个文件
        //前端要做的是设计从用户处得到文件的方式并把文件展示给后端，前后端遵照对接规则，后端利用得到的文件和其他信息进行操作
        //对接规则包括：前端为后端提供了什么数据，调用哪一个后端程序（ResponseMapping）
        //本例子中，前端得到用户的请求信息和文件
        //后端负责将文件保存起来（保存在本机，服务器）
        //其实后端做的就是一个文件另存为

        //1、获取
        String name = request.getParameter("name");//有一个name，有一个head_img，从html代码中看到
        System.out.println("用户名："+name);
        //获取文件名
        String filename = file.getOriginalFilename();
        System.out.println("上传的文件名为："+filename);
        //获取后缀
        String suffixName = filename.substring(filename.lastIndexOf("."));//字符串操作
        System.out.println("文件后缀为："+suffixName);
        //文件上传后路径
        filename = UUID.randomUUID()+suffixName;
        File dest = new File(filePath+filename);
        System.out.println(filePath);

        //2、保存
        try {
            file.transferTo(dest);
            return new JsonData(0,filename);//体会到了Object的妙用，想给前端看什么就传什么
        } catch (IllegalStateException e) {
            System.out.println("1 st");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("2 nd");
            e.printStackTrace();
        }
        return new JsonData(-1,"failed");//为了信息保密。给前端返回状态码
    }

}
/*
一般大型项目大企业不再把静态资源文件放在项目中，使用CDN（内容分发网）
spring boot是前后端分离的，所以一般也不把资源文件放到项目中，而是放在资源服务器上。大幅度减少jar包大小！很重要
 */