package com.huang.study.test;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2019/6/11 13:29
 */
public class Calculate {
    public static void main(String[] args) {
        int a = 100;
        int b = 200;
        System.out.println(a);
        System.out.println(b);
        System.out.println("------");
        a = a^ b;
        System.out.println(a);
        b = a^ b;
        System.out.println(b);
        a = a^ b;
        System.out.println(a);
        System.out.println(b);
    }
}
