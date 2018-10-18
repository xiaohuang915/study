package com.huang.study.pattern.abstractfactory.demo1;

/**
 * @Auther: pc.huang
 * @Date: 2018/7/27 14:37
 * @Description:
 */
public class SpringButton implements Button {
    @Override
    public void display() {
        System.out.println("绿色按钮");
    }
}
