package com.huang.study.test.service;

import com.alibaba.fastjson.annotation.JSONField;
import com.huang.study.test.A;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2019-05-05 13:48
 */
@Getter
@Setter
@ToString
public class TestJson {

    @ApiModelProperty(value = "商户号")
    @JSONField(name = "MERCHANT_ID")
    private String merchantId;

    @ApiModelProperty(value = "文件名")
    @JSONField(serialize = false)
    private String fileName;

    @JSONField(name = "DETAIL")
    private List<A> detail;
}
