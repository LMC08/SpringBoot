package com.example.demo.demo;

/**
 * @Author Ting Wang
 * @Description 懒汉单例   静态内部类, 外部实例化，并不会初始化内部类，只有调用内部类的时候才会实例化内部类，
 *                       因为是内部类加载和初始化，不存在多线程问题，线程安全
 * @Date 2021/3/18
 */
public class Singleton4 {
    //构造器私有化
    private Singleton4() {
    }

   private static class Inner {
        private static final Singleton4 instance = new Singleton4();
    }

    public static Singleton4 getInstance(){
        return Inner.instance;
    }
}
