package com.huang.study.template;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/6/16 14:34
 */
public class TestCar {

    public static void main(String[] args) {
        AbstractCar car = new Motorcycle();
        car.makeCar();
        System.out.println("-----");
        car = new ElectricVehicle();
        car.makeCar();
        System.out.println("-----");
        car = new Bicycle();
        car.makeCar();
    }
}
