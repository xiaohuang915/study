package com.huang.study.hutool;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/5/18 13:14
 */
public class HeapMemUseTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        while(true) {
            sb.append(System.currentTimeMillis());
        }
    }
}
