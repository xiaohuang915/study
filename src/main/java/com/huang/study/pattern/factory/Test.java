package com.huang.study.pattern.factory;

/**
 * @Auther: pc.huang
 * @Date: 2018/7/27 17:49
 * @Description:
 */
public class Test {
    public static void main(String[] args){
      Creator creator = new ConcreteCreator();
        ConcreateProduct2 product = creator.createProduct(ConcreateProduct2.class);
        product.method2();
    }
}
