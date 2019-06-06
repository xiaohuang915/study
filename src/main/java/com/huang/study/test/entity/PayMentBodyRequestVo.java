package com.huang.study.test.entity;

import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 * @Description: 中行线上支付请求体对象
 * @Author : pc.huang
 * @Date : 2019/5/31 15:10
 */
@Setter
public class PayMentBodyRequestVo implements Serializable {
    private static final long serialVersionUID = -6276379494082475822L;

    /**
     * 商户号
     */
    private String merchantNo;

    /**
     * 卡号
     */
    private String cardNo;
    /**
     * 终端类型
     * 他行卡支付时必填
     * 07	电脑
     * 08	手机
     * 10	平板设备
     * 18	可穿戴设备
     * 19	数字电视
     * 00	其他
     */
    private String terminalChnl;
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 协议号
     */
    private String agrmtNo;
    /**
     * 货币码  001
     */
    private String curCode;
    /**
     * 订单金额
     */
    private String orderAmount;
    /**
     * 订单时间 格式YYYYMMDDHHMMSS
     */
    private String orderTime;
    /**
     * 订单说明 选填
     * 订单描述，要求如果全中文最多允许60个汉字长度
     */
    private String orderNote;

    @XmlElement(name = "MERCHANTNO")
    public String getMerchantNo() {
        return merchantNo;
    }

    @XmlElement(name = "CARD_NO")
    public String getCardNo() {
        return cardNo;
    }

    @XmlElement(name = "TERMINAL_CHNL")
    public String getTerminalChnl() {
        return terminalChnl;
    }

    @XmlElement(name = "ORDER_NO")
    public String getOrderNo() {
        return orderNo;
    }

    @XmlElement(name = "AGRMTNO")
    public String getAgrmtNo() {
        return agrmtNo;
    }

    @XmlElement(name = "CUR_CODE")
    public String getCurCode() {
        return curCode;
    }

    @XmlElement(name = "ORDER_AMOUNT")
    public String getOrderAmount() {
        return orderAmount;
    }

    @XmlElement(name = "ORDER_TIME")
    public String getOrderTime() {
        return orderTime;
    }

    @XmlElement(name = "ORDER_NOTE")
    public String getOrderNote() {
        return orderNote;
    }
}
