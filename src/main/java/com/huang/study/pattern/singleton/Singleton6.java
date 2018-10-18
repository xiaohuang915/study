package com.huang.study.pattern.singleton;

/**
 * @Auther: pc.huang
 * @Date: 2018/7/26 12:01
 * @Description: 双重校验锁
 * 如果instance为空才执行加锁操作
 * 在JDK1.5之后，双重检查锁定才能够正常达到单例效果
 */
public class Singleton6 {
    private volatile static Singleton6 instance;

    private Singleton6() {

    }

    public static Singleton6 getInstance() {
        if (instance == null) {
            synchronized (Singleton6.class) {
                if (instance == null) {
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }

}
