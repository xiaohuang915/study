package com.huang.study.pattern.abstractfactory.demo2;

/**
 * @Auther: pc.huang
 * @Date: 2018/8/21 14:40
 * @Description:
 */
public class RestaurantShanghai extends AbstractFactory {
    @Override
    public Eat createRestaurantEat() {
        return new EatShanghai();
    }

    @Override
    public Drink creatRestaurantDrink() {
        return new DrinkShanghai();
    }
}
