package com.huang.study.function;

import java.util.function.Function;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/3/6 11:14
 */
public class FunctionTest {

    public static void main(String[] args) {
        Function<Integer,Integer> fun1 = i->i+1;
        Function<Integer,Integer> fun2 = i->i*2;
        System.out.println(excu(2, fun1));
        System.out.println(excu(2, fun2));
        System.out.println(fun2.compose(fun1).apply(2));
        System.out.println(fun2.andThen(fun1).apply(2));
    }


    public static <T,R> R excu(T a,Function<T,R> fun){
       return fun.apply(a);
    }

    public static <T,R> R excu1(T a, Function<T, R> fun, Function<Object, R> fun2){
        return fun.andThen(fun2).apply(a);
    }
}
