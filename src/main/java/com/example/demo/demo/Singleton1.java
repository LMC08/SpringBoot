package com.example.demo.demo;

/**
 * @Author Ting Wang
 * @Description  饿汉单例
 * @Date 2021/3/18
 */
public class Singleton1 {
    //构造器私有化
    private Singleton1(){ }
    public static final Singleton1 instance = new Singleton1();
}
