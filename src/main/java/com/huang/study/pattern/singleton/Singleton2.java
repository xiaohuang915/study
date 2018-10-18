package com.huang.study.pattern.singleton;

/**
 * @Auther: pc.huang
 * @Date: 2018/7/26 12:01
 * @Description: 饿汉，避免了多线程问题，初试化静态的instance创建一次。
 * 如果我们在Singleton类里面写一个静态的方法不需要创建实例，它仍然会早早的创建一次实例。而降低内存的使用率。
 * 缺点：没有lazy loading的效果，从而降低内存的使用率。
 */
public class Singleton2 {
    private static Singleton2 instance = new Singleton2();

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}
