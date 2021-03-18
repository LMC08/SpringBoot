package com.example.demo.demo;

/**
 * @Author Ting Wang
 * @Description 懒汉单例
 * @Date 2021/3/18
 */
public class Singleton3 {
    //构造器私有化
    private Singleton3() {
    }

    private static Singleton3 instance;

    public static Singleton3 getInstance() {
        if (instance == null) {
            return new Singleton3();
        }
        return instance;
    }
}
