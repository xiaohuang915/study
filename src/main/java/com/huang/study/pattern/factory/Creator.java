package com.huang.study.pattern.factory;

/**
 * @Auther: pc.huang
 * @Date: 2018/7/27 17:34
 * @Description: 抽象工厂类
 */
public abstract class Creator {
    public abstract <T extends Product> T createProduct(Class<T> c);
}
