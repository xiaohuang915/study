package com.huang.study.base.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: pc.huang
 * @Date: 2018/8/31 17:09
 * @Description:
 */
public class Lambda {
    @Test
    public void testForEach(){
        List<String> lists = Arrays.asList("aa","bb","cc");
        lists.forEach(s -> System.out.println(s));
    }
}
