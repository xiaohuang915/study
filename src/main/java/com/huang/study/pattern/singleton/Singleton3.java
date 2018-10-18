package com.huang.study.pattern.singleton;

/**
 * @Auther: pc.huang
 * @Date: 2018/7/26 12:01
 * @Description: 饿汉模式变种
 * 其实和第三种方式差不多，都是在类初始化即实例化instance。
 */
public class Singleton3 {
    private static Singleton3 instance = null;

    static {
        instance = new Singleton3();
    }

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        return instance;
    }
}
