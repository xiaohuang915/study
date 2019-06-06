package com.huang.study.test.entity;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2019/6/5 15:59
 */
public class FileUtil {

    /**
     * 从classpath下获取文件
     *
     * @param path
     * @return
     */
    public static InputStream loadInputStreamFromPath(String path) {
        ClassPathResource resource = new ClassPathResource(path);
        try {
            return resource.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    /**
     * 获取文件流的string字符串
     *
     * @param in
     * @return
     */
    public static String getStringFromInputStream(InputStream in) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String readLine = null;
            StringBuilder sb = new StringBuilder();
            while ((readLine = br.readLine()) != null) {
                if (readLine.charAt(0) == '-') {
                    continue;
                } else {
                    sb.append(readLine);
                    sb.append('\r');
                }
            }
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
