package com.huang.study.test;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2019-02-28 15:51
 */
@Getter
@Setter
public class C extends A {
    private String pwd;

    public String get() {
        return pwd + "cc反射执行方法获取值";
    }

}
