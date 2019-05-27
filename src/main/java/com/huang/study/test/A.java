package com.huang.study.test;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2019-02-28 15:51
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public  class A {

    @JSONField(name = "ID")
    private String id = "父类id";

    private Long amount;

    private String error;

}
