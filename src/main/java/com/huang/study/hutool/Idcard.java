package com.huang.study.hutool;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.json.JSONUtil;


/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/4/27 15:31
 */
public class Idcard {
    public static void main(String[] args) {
        String ID_18 = "321083197812162119";
        String ID_15 = "150102880730303";

        //是否有效
        boolean valid = IdcardUtil.isValidCard(ID_18);
        boolean valid15 = IdcardUtil.isValidCard(ID_15);

        //转换
        String convert15To18 = IdcardUtil.convert15To18(ID_15);

        //年龄
        DateTime date = DateUtil.parse("2017-04-10");

        int age = IdcardUtil.getAgeByIdCard(ID_18, date);

        int age2 = IdcardUtil.getAgeByIdCard(ID_15, date);

        //生日
        String birth = IdcardUtil.getBirthByIdCard(ID_18);

        String birth2 = IdcardUtil.getBirthByIdCard(ID_15);

        //省份
        String province = IdcardUtil.getProvinceByIdCard(ID_18);

        String province2 = IdcardUtil.getProvinceByIdCard(ID_15);

        Cache<String,String> fifoCache = CacheUtil.newFIFOCache(3);
        //加入元素，每个元素可以设置其过期时长，DateUnit.SECOND.getMillis()代表每秒对应的毫秒数，在此为3秒
        fifoCache.put("key1", "value1", DateUnit.SECOND.getMillis() * 3);
        fifoCache.put("key2", "value2", DateUnit.SECOND.getMillis() * 3);
        fifoCache.put("key3", "value3", DateUnit.SECOND.getMillis() * 3);

//由于缓存容量只有3，当加入第四个元素的时候，根据FIFO规则，最先放入的对象将被移除
        fifoCache.put("key4", "value4", DateUnit.SECOND.getMillis() * 3);

        JSONUtil.toJsonStr(fifoCache);


    }
}
