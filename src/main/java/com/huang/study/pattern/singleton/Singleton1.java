package com.huang.study.pattern.singleton;

/**
 * @Auther: pc.huang
 * @Date: 2018/7/26 12:01
 * @Description: 懒汉，线程安全,效率很低，99%情况下不需要同步
 */
public class Singleton1 {
    private static Singleton1 instance;

    private Singleton1() {
    }

    public synchronized static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
