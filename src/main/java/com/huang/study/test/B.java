package com.huang.study.test;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2019-02-28 15:51
 */
@Getter
@Setter
public class B extends A {
    private String name;

    private String id;

    public static String s;


    public static void main(String[] args) {
        StringBuilder targ = new StringBuilder();
        targ.append("cspssc");
        for (int i = 0; i < 194; i++) {
            targ.append(' ');
        }
        System.out.println(targ.toString());
        System.out.println(targ.length());
    }

    @PostConstruct
    private static void test() {
        StringBuilder targ = new StringBuilder();
        targ.append("cspssc");
        for (int i = 0; i < 194; i++) {
            targ.append(" ");
        }
        s = targ.toString();
    }

}
