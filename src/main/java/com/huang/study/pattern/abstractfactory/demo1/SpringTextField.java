package com.huang.study.pattern.abstractfactory.demo1;

/**
 * @Auther: pc.huang
 * @Date: 2018/7/27 14:40
 * @Description:
 */
public class SpringTextField implements TextField {
    @Override
    public void display() {
        System.out.println("绿色文本框");
    }
}
