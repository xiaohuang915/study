package com.huang.study.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.huang.study.thread.syn.Main;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020-08-02 16:32
 */
public class GuavaStringTest {

    public static void main(String[] args) {
        Map<String, String> mapSrc = new HashMap<>();
        mapSrc.put("key0", "value0");
        mapSrc.put("key1", "value1");
        String resultString = Joiner.on("&")
                .withKeyValueSeparator("=")
                .join(mapSrc);
        System.out.println(resultString);

        Map<String, String> resultMap = Splitter.on("&").withKeyValueSeparator("=").split(resultString);
        for (Map.Entry<String, String> entry : resultMap.entrySet()) {
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }

        System.out.println(Strings.padStart("9527", 6, '0'));
        System.out.println(Strings.padEnd("9527", 6, '0'));
        System.out.println(Strings.repeat("mghio", 3));
    }
}
