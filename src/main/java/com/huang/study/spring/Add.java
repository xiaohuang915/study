package com.huang.study.spring;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/3/23 15:55
 */
public class Add implements CalService {
    @Override
    public int excule(int a, int b) {
        return a + b;
    }
}
