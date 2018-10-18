package com.huang.study.pattern.abstractfactory.demo2;

/**
 * @Auther: pc.huang
 * @Date: 2018/8/21 14:29
 * @Description: 抽象工厂类
 */
public abstract class AbstractFactory {
    public abstract Eat createRestaurantEat();
    public abstract Drink creatRestaurantDrink();
}
