package com.huang.study.base.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @Auther: pc.huang
 * @Date: 2018/9/13 09:54
 * @Description: 1.8方法引用
 */
public class Method {
    public static Method create(final Supplier<Method> supplier) {
        return supplier.get();
    }

    public static void collide(final Method method) {
        System.out.println("Collide" + method.toString());
    }

    public void follow(final Method method) {
        System.out.println("follow" + method.toString());
    }

    public void repair() {
        System.out.println("repair" + this.toString());
    }

    public static void main(String[] args) {
        final Method method = Method.create(Method::new);
        final List<Method> methods = Arrays.asList(method);
        methods.forEach(Method::repair);
    }
}
