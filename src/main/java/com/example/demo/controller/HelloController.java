package com.example.demo.controller;


import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HellowController
 * @Description:
 * @Author liminchuan
 * @Date:Create： 2021/3/2 16:28
 */
@RestController
public class HelloController {
    // 获取.yml 文件中值
    @Value("${name}")
    private String name;

    // 获取 age
    @Value("${age}")
    private int age;

    @Autowired
    private User user;

    @RequestMapping("/hello")
    public String hello() {
        return name + ":" + age;
    }

    @RequestMapping("/getUser")
    public String getUser() {
        return user.getBigName()+":"+user.getAge();
    }
}
