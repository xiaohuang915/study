package com.huang.study.test.entity;

import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 * @Description: 中行开户结果通知请求对象
 * @Author : pc.huang
 * @Date : 2019-05-23 09:51
 */
@Setter
public class AccountOpenNotifyBodyRequestVo implements Serializable {
    private static final long serialVersionUID = 4662169841694689278L;

    /**
     * 开户申请编号
     */
    private String applyId;

    /**
     * 申请编号
     */
    private String uuid;

    /**
     * 开户标识 1-开户成功 2-开户失败
     */
    private String flag;

    /**
     * 证件类别
     * 必输（采用BANCS标准）默认01
     * 01－居民身份证
     * 02－临时身份证
     * 03－护照
     * 04－户口簿
     * 05－军人身份证
     * 06－武装警察身份证
     * 08－外交人员身份证
     * 09－外国人居留许可证
     * 10－边民出入境通行证
     * 11－其它
     * 47－港澳居民来往内地通行证（香港）
     * 48－港澳居民来往内地通行证（澳门）
     * 49－台湾居民来往大陆通行证
     */
    private String certType;

    /**
     * 证件号码
     */
    private String certNo;

    /**
     * 客户名称
     */
    private String custName;

    /**
     * 客户名
     */
    private String name;

    /**
     * 客户姓
     */
    private String surName;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 关联账户类型
     */
    private String cardType;

    /**
     * 关联账户号(借记卡)
     */
    private String cardNo;

    /**
     * 他行卡号 绑定卡卡号
     */
    private String otherBankCard;

    /**
     * ACC渠道标识
     */
    private String accChannelFlag;

    /**
     * 核心客户号
     */
    private String bancsCustNo;

    /**
     * 是否联机 0-联机 1-调度
     */
    private String isOnlineSubmit;

    /**
     * 二三类账户号
     */
    private String cardACC;

    /**
     * 原始code
     */
    private String resultCode;

    /**
     * 原始msg  未包装的开户结果信息
     */
    private String resultMsg;

    /**
     * 返回错误信息的场景
     */
    private String remark1;

    @XmlElement(name = "applyId")
    public String getApplyId() {
        return applyId;
    }

    @XmlElement(name = "uuid")
    public String getUuid() {
        return uuid;
    }

    @XmlElement(name = "flag")
    public String getFlag() {
        return flag;
    }

    @XmlElement(name = "certType")
    public String getCertType() {
        return certType;
    }

    @XmlElement(name = "certNo")
    public String getCertNo() {
        return certNo;
    }

    @XmlElement(name = "custName")
    public String getCustName() {
        return custName;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    @XmlElement(name = "surName")
    public String getSurName() {
        return surName;
    }

    @XmlElement(name = "phone")
    public String getPhone() {
        return phone;
    }

    @XmlElement(name = "address")
    public String getAddress() {
        return address;
    }

    @XmlElement(name = "cardType")
    public String getCardType() {
        return cardType;
    }

    @XmlElement(name = "cardNo")
    public String getCardNo() {
        return cardNo;
    }

    @XmlElement(name = "otherBankCard")
    public String getOtherBankCard() {
        return otherBankCard;
    }

    @XmlElement(name = "accChannelFlag")
    public String getAccChannelFlag() {
        return accChannelFlag;
    }

    @XmlElement(name = "bancsCustNo")
    public String getBancsCustNo() {
        return bancsCustNo;
    }

    @XmlElement(name = "isOnlineSubmit")
    public String getIsOnlineSubmit() {
        return isOnlineSubmit;
    }

    @XmlElement(name = "cardACC")
    public String getCardACC() {
        return cardACC;
    }

    @XmlElement(name = "resultCode")
    public String getResultCode() {
        return resultCode;
    }

    @XmlElement(name = "resultMsg")
    public String getResultMsg() {
        return resultMsg;
    }

    @XmlElement(name = "remark1")
    public String getRemark1() {
        return remark1;
    }
}
