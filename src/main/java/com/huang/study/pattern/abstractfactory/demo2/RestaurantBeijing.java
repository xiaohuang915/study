package com.huang.study.pattern.abstractfactory.demo2;

/**
 * @Auther: pc.huang
 * @Date: 2018/8/21 14:39
 * @Description:
 */
public class RestaurantBeijing extends AbstractFactory {
    @Override
    public Eat createRestaurantEat() {
        return new EatBeijing();
    }

    @Override
    public Drink creatRestaurantDrink() {
        return new DrinkBeijing();
    }
}
