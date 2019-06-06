package com.huang.study.test.entity;

import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @Description: 中行支付相关请求头对象
 * @Author : pc.huang
 * @Date : 2019/5/31 15:10
 */
@Setter
//控制生成的顺序
@XmlType(propOrder = {"txSn","trnType","reqType","agentCode"})
public class HeadRequestVo implements Serializable {
    private static final long serialVersionUID = -8042925831555866904L;

    /**
     * 单位编码 29028001
     */
    private String agentCode;

    /**
     * 请求类型 0200
     */
    private String reqType;

    /**
     * 交易类型 PAY000
     */
    private String trnType;

    /**
     * 前端流水号
     */
    private String txSn;

    @XmlElement(name = "AGENT_CODE")
    public String getAgentCode() {
        return agentCode;
    }

    @XmlElement(name = "REQUEST_TYPE")
    public String getReqType() {
        return reqType;
    }

    @XmlElement(name = "TRN_CODE")
    public String getTrnType() {
        return trnType;
    }

    @XmlElement(name = "FRONT_TRACENO")
    public String getTxSn() {
        return txSn;
    }
}
