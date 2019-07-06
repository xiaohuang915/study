package com.huang.study.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @Description: json test
 * @Author : pc.huang
 * @Date : 2019-07-06 20:20
 */
@Getter
@Setter
public class JsonTest {
    //ordinal 设置序列化后属性排序顺序

    @JSONField(ordinal = 4, name = "ID")
    private String id;

    @JSONField(ordinal = 2, name = "NAME")
    private String name;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime create;

    public static void main(String[] args) {
        JsonTest jsonTest = new JsonTest();
        jsonTest.setId("11");
        jsonTest.setName("222");
        jsonTest.setCreate(LocalDateTime.now());
        System.out.println(JSON.toJSONString(jsonTest));
    }
}
