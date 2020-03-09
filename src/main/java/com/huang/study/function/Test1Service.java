package com.huang.study.function;

import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/3/6 11:30
 */
@Service
public class Test1Service {

    public  String login(String name) {
        return "test1ServiceLogin----" + name;
    }
}
