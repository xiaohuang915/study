package com.huang.study.template;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/6/16 14:22
 */
public abstract class AbstractCar {

    final void makeCar() {
        //选轮胎
        tyre();
        //选颜色
        colour();
        //选外壳
        shell();
    }

    abstract void tyre();

    abstract void colour();

    void shell() {
        System.out.println("默认外壳");
    }

}
