package com.huang.study.template;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/6/16 14:31
 */
public class Motorcycle extends AbstractCar {
    @Override
    void tyre() {
        System.out.println("摩托车");
    }

    @Override
    void colour() {
        System.out.println("黑色");
    }

    @Override
    void shell() {
        System.out.println("金属外壳");
    }
}
