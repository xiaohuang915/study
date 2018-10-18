package com.huang.study.pattern.singleton;

/**
 * @Auther: pc.huang
 * @Date: 2018/7/26 15:18
 * @Description: 测试类
 */
public class TestSingleton {
    public static void main(String[] args) {
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton1.getInstance());
        System.out.println(Singleton1.getInstance());
        System.out.println(Singleton2.getInstance());
        System.out.println(Singleton2.getInstance());
        System.out.println(Singleton3.getInstance());
        System.out.println(Singleton3.getInstance());
        System.out.println(Singleton4.getInstance());
        System.out.println(Singleton4.getInstance());
        Singleton5.INSTANCE.get();
        Singleton5.INSTANCE.get();
        System.out.println(Singleton6.getInstance());
        System.out.println(Singleton6.getInstance());
    }
}
