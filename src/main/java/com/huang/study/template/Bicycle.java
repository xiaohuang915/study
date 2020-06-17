package com.huang.study.template;

import javax.xml.bind.SchemaOutputResolver;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/6/16 14:36
 */
public class Bicycle extends AbstractCar {
    @Override
    void tyre() {
        System.out.println("自行车");
    }

    @Override
    void colour() {
        System.out.println("蓝色");
    }


}
