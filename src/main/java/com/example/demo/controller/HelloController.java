package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HellowController
 * @Description:
 * @Author liminchuan
 * @Date:Create： 2021/3/2 16:28
 */
@RestController
public class HelloController {
    @RequestMapping("/")
    public String hello(){
        return "hello world";
    }
}
