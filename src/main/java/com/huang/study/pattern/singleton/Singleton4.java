package com.huang.study.pattern.singleton;

/**
 * @Auther: pc.huang
 * @Date: 2018/7/26 12:01
 * @Description: 静态内部类
 * 定义一个私有的内部类，在第一次用这个嵌套类时，会创建一个实例。
 * 而类型为SingletonHolder的类，只有在Singleton.getInstance()中调用，
 * 由于私有的属性，他人无法使用SingleHolder，不调用Singleton.getInstance()就不会创建实例。
 * 优点：达到了lazy loading的效果，即按需创建实例
 */
public class Singleton4 {
    private Singleton4() {

    }

    private static class SingletonHolder {
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
