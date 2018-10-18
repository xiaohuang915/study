package com.huang.study.pattern.factory;

/**
 * @Auther: pc.huang
 * @Date: 2018/7/27 17:35
 * @Description:  具体产生产品对象
 */
public class ConcreteCreator extends Creator {
    @Override
    public <T extends Product> T createProduct(Class<T> c) {
        Product product = null;
        try {
            product = (Product)Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) product;
    }
}
