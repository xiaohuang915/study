package com.huang.study.template;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/6/16 14:29
 */
public class ElectricVehicle extends AbstractCar {
    @Override
    void tyre() {
        System.out.println("电动汽车");
    }

    @Override
    void colour() {
        System.out.println("红色");
    }

    @Override
    void shell() {
        System.out.println("金属外壳");
    }

}
