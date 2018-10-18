package com.huang.study.pattern.singleton;

/**
 * @Auther: pc.huang
 * @Date: 2018/7/26 15:36
 * @Description: 枚举
 * 它不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象
 */
public enum Singleton5 {
    INSTANCE;
    public void get(){
        System.out.println("枚举");
    }
}
