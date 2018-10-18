package com.huang.study.pattern.abstractfactory.demo2;

/**
 * @Auther: pc.huang
 * @Date: 2018/8/21 14:41
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
      AbstractFactory abstractFactory = new RestaurantShanghai();
        Eat restaurantEat = abstractFactory.createRestaurantEat();
        restaurantEat.eat();
        Drink drink = abstractFactory.creatRestaurantDrink();
        drink.drink();
    }
}
