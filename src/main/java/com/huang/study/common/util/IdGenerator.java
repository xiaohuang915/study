package com.huang.study.common.util;


import com.baomidou.mybatisplus.core.toolkit.IdWorker;

/**
 * 唯一id生成器
 */
public class IdGenerator {

    public static String getId() {
        return String.valueOf(IdWorker.getId());
    }

    public static long getIdLong() {
        return IdWorker.getId();
    }
}
