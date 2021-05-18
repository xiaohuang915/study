package com.huang.study.zset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2021/5/18 10:16
 */
@Service
public class Test11 {

    @Autowired
    private RedisTemplate<String,UserInfo> redisTemplate;

    private String key = "testscore2";

    public void score(){
        redisTemplate.opsForZSet().incrementScore(key, new UserInfo("123", "橙子\\uD83C\\uDF4A"), 11);
        redisTemplate.opsForZSet().incrementScore(key, new UserInfo("456", "一眼看不出"), 2);
        redisTemplate.opsForZSet().incrementScore(key, new UserInfo("789", "啾"), 10);

        Set<ZSetOperations.TypedTuple<UserInfo>> typedTuples = redisTemplate.opsForZSet().reverseRangeWithScores(key, 0, 10);
        for (ZSetOperations.TypedTuple<UserInfo> typedTuple : typedTuples) {
            System.out.println(typedTuple.getScore()+"---"+typedTuple.getValue().toString());
        }

    }
}
