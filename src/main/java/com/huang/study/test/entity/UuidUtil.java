package com.huang.study.test.entity;

import java.util.UUID;

/**
 * @Description: uuid工具类
 * @Author : pc.huang
 * @Date : 2019-02-21 16:45
 */
public class UuidUtil {
    private static SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(1,2);

    /**
     * 获取大写的uuid
     *
     * @return uuid
     */
    public static String getUpperId() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    /**
     * 获取交易流水号
     *
     * @return
     */
    public static String getTxsn() {
        return snowflakeIdWorker.nextStrId();
    }
}
