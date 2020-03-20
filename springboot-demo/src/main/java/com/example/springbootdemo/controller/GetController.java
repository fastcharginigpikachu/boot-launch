package com.example.springbootdemo.controller;

import com.example.springbootdemo.domain.ServerSettings;
import com.example.springbootdemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.ObjenesisException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController//返回json格式给前端
public class GetController {
    private Map<String,Object> params = new HashMap<>();
    /**
     * 功能：测试restful协议，从路径中获取字段.路径是变量，页面返回路径中的变量
     * @param cityId
     * @param userId
     * @return
     */
    /*@RequestMapping(path = "/{city_id}/{user_id}",method = RequestMethod.GET)//{}中放变量，实现了动态网址！ 网址中最好不用驼峰命名，防止系统其他代码是大小写不敏感的
    public Object findUser(@PathVariable("city_id") String cityId,@PathVariable("user_id") String userId) {//@PathVariable("city_id") String cityId实现了路径变量赋值给代码中变量
        //把从路径中取出的变量复制给哈希表params，然后取出
        params.clear();
        params.put("cityID",cityId);
        params.put("userID",userId);
        return params;
   }*/

    /**
     * 功能：测试GetMapping
     * @param from
     * @param size
     * @return
     */
    @GetMapping(value = "/v1/page_user1")//包装了RequestMappibng，method=get
    public Object pageuser(int from,int size) {
        params.clear();
        params.put("from",from);
        params.put("size",size);

        return params;
    }

    /**
     * 功能：默认值，是否是必须的参数
     * @param from
     * @param size
     * @return
     */
    @GetMapping(value = "/v1/page_user2")
    public Object pageUser2(@RequestParam(defaultValue = "2",name = "page") int from,int size) {//from的默认值是2，写在了参数列表的注释里，不必写在函数里，并且命了一个名字
        params.clear();
        params.put("from",from);
        params.put("size",size);
        return params;
    }

    /**
     * 功能：bean对象传输
     * 注意：指定http headers为：content-type:application/json    使用body传输数据
     * @param user
     * @return
     */
    @GetMapping("/v1/save_user")
    public Object saveUser(@RequestBody User user) {//@RequestBody:后面注释的类，定义或显示时，以json格式
        params.clear();
        params.put("user",user);
        return params;
    }

    @GetMapping("/v1/get_header")
    public Object getHeader(@RequestHeader("access_token") String accessToken,String id) {//取得令牌，查看是否有权限继续访问
        params.clear();
        params.put("accessToken",accessToken);
        params.put("id",id);
        return params;
    }

    @GetMapping("/v1/test_request")
    public Object testRequest(HttpServletRequest request) {//自动注入参数
        params.clear();
        String id = request.getParameter("id");
        params.put("id",id);
        return id;
    }

    @Autowired//类->对象
    private ServerSettings serverSettings;
    @GetMapping("api2/v1/test_properties")
    public Object testProperties() {
        return serverSettings;
    }

}
