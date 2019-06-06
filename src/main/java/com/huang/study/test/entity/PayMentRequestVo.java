package com.huang.study.test.entity;

import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @Description: 中行线上支付请求对象
 * @Author : pc.huang
 * @Date : 2019/5/31 15:10
 */
@XmlRootElement(name = "UTILITY_PAYMENT")
@Setter
public class PayMentRequestVo implements Serializable {
    private static final long serialVersionUID = -3858090861145210982L;

    /**
     * 请求体对象
     */
    private PayMentBodyRequestVo payMentBodyRequestVo;
    /**
     * 请求头对象
     */
    private HeadRequestVo headRequestVo;

    @XmlElement(name = "CONST_BODY")
    public PayMentBodyRequestVo getPayMentBodyRequestVo() {
        return payMentBodyRequestVo;
    }

    @XmlElement(name = "CONST_HEAD")
    public HeadRequestVo getHeadRequestVo() {
        return headRequestVo;
    }
}
