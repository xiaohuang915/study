package com.huang.study.spring;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/3/23 15:56
 */
public class Sub implements CalService {
    @Override
    public int excule(int a, int b) {
        return a - b;
    }
}
