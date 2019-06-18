package com.huang.study.test.copy;

import org.springframework.cglib.beans.BeanCopier;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2019/6/12 11:07
 */
public class CopyTest {
    @Short(2)
    private String name = "test";

    @Short(3)
    private String id = "123";

    @Short(1)
    private String phone = "100";

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        CopyTest copyTest = new CopyTest();
        String unSignedString = getUnSignedString(copyTest);
        System.out.println(unSignedString);
    }

    public static <T> T copy(Object soure, Class<T> targe) throws IllegalAccessException, InstantiationException {
        BeanCopier beanCopier = BeanCopier.create(soure.getClass(), targe, false);
        T t = targe.newInstance();
        beanCopier.copy(soure, t, null);
        return t;
    }


    public static String getUnSignedString(Object data) {
        Field[] declaredFields = data.getClass().getDeclaredFields();

        // 只需要注解标识的字段
        return Arrays.stream(declaredFields)
                .filter(f -> f.isAnnotationPresent(Short.class))
                .filter(a -> {
                    try {
                        a.setAccessible(true);
                        return null != a.get(data);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return false;
                })
                .sorted(Comparator.comparing(f -> f.getAnnotation(Short.class).value()))
                .map(f -> {
                    try {
                        f.setAccessible(true);
                        Object o = f.get(data);
                        return f.getName() + "=" + o;
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return "";
                })
                .collect(Collectors.joining("&"));
    }

}
