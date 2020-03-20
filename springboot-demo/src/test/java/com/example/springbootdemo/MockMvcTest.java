package com.example.springbootdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDemoApplication.class)
@AutoConfigureMockMvc//配置MVC
public class MockMvcTest {
    @Autowired//注入
    private MockMvc mockMvc;//http客户端，源代码值得看

    @Test
    public void apiTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/test/home")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();//用某方法访问url，表明期待得到状的态，并返回
        int status = mvcResult.getResponse().getStatus();//以上两个函数还有很多好用的API
        System.out.println(status);
    }
}
