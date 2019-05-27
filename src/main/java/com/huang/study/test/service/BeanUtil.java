package com.huang.study.test.service;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Field;

/**
 * @Description: 实体类工具类
 * @Author : pc.huang
 * @Date : 2019-01-21 16:51
 */
public class BeanUtil {
    /**
     * @Description: 属性拷贝可实现深拷贝
     * @param: [obj, clazz]
     * @return: T
     * @auther: pc.huang
     * @date: 2019-01-21 20:33
     */
    public static <T> T beanCopy(Object obj, Class<T> clazz, boolean isCopyParent) {
        try {
            T t = JSON.parseObject(JSON.toJSONString(obj)).toJavaObject(clazz);
            Field[] toFields = t.getClass().getDeclaredFields();
            if (isCopyParent) {
                Class<?> superClass = obj.getClass().getSuperclass();
                Field[] parentFields = superClass.getDeclaredFields();

                for (Field parentField : parentFields) {
                    for (Field toField : toFields) {
                        if (parentField.getName().equals(toField.getName())) {
                            parentField.setAccessible(true);
                            toField.setAccessible(true);
                            toField.set(t,parentField.get(superClass));
                        }
                    }
                }
            }
            return t;

        } catch (Exception e) {

        }
        return null;
    }

}
