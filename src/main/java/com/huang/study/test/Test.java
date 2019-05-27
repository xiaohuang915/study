package com.huang.study.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2019-02-15 16:44
 */
public class Test {

    /**
     * envelope : {"head":{"sysId":"gh00001","charset":"UTF-8","timestamp":"20190308133558","serialValue":"2019030800000000004","version":"3.0","orgcode":"gh01"},"body":{"serviceCode":"B1006_0001_00","parameters":{"ZHLX":"1","ZCLY":"2023","SJHM":"135*******","SHBH":"008999988","SHHYID":"1234443"}}}
     * signature :
     */


    public static void main(String[] args) throws Exception {
//        B b = new B();
//        b.setName("名称");
//        D d = BeanUtil.beanCopy(b, D.class, false);
//        System.out.println(JSON.toJSONString(d));
        List<A> list = new ArrayList<>();

        A a = new A();
        a.setId("111");
        a.setAmount(1L);
        list.add(a);

        A a1 = new A();
        a1.setId("111");
        a1.setAmount(2L);
        list.add(a1);

        A a3 = new A();
        a3.setId("222");
        a3.setAmount(3L);
        list.add(a3);

        list.stream().collect(Collectors.groupingBy(A::getId)).forEach((k, v) -> {
            if (v.size() > 1) {
                v.forEach(b -> {
                    b.setError("错误");
                    System.out.println(b);
                });
            }
        });
        System.out.println(list);

//        String s = JSON.toJSONString(list);
//        System.out.println(s);
//        System.out.println(JSON.parseArray(s, A.class));
//        JSONArray objects = JSONObject.parseArray(s);
//        System.out.println(objects);


//        A a1 = new A();
//        a1.setAmount(1L);
//        list.add(a1);
//
//        System.out.println(JSON.toJSONString(list));
//
//        list.stream().filter(b -> b.getAmount() > 0).collect(Collectors.toList());
//        System.out.println("过滤后 " + JSON.toJSONString(list));
    }

    public static <T> void get(T t) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        Field[] declaredFields = t.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            System.out.println(declaredField.getName());
            System.out.println(declaredField.get(t));
            map.put(declaredField.getName(), declaredField.get(t));
            stringBuilder.append(declaredField.getName()).append("=").append(declaredField.get(t)).append("&");
        }
        String signSrc = stringBuilder.toString();
        if (signSrc.endsWith("&")) {
            signSrc = signSrc.substring(0, signSrc.length() - 1);
        }
        System.out.println(signSrc);
        map.forEach((k, v) -> {
            System.out.println("k=" + k + "v=" + v);
        });
    }


}
