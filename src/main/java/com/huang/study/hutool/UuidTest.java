package com.huang.study.hutool;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/4/27 9:41
 */
public class UuidTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(IdUtil.fastUUID());
        System.out.println(IdUtil.randomUUID());
        System.out.println(IdUtil.simpleUUID());
        System.out.println(IdUtil.fastSimpleUUID());
        Snowflake snowflake = IdUtil.getSnowflake(1, 2);
        System.out.println(snowflake.nextIdStr());
        System.out.println(snowflake.nextIdStr());
        System.out.println(IdUtil.objectId());
    }
}
