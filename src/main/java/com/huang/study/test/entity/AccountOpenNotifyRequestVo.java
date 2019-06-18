package com.huang.study.test.entity;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @Description: 中行开户结果通知请求对象
 * @Author : pc.huang
 * @Date : 2019-05-23 09:51
 */
@Getter
@Setter
@XmlRootElement(name = "tdgService")
public class AccountOpenNotifyRequestVo implements Serializable {
    private static final long serialVersionUID = 4662169841694689278L;

   private AccountOpenNotifyHeadRequestVo headRequestVo;

   private AccountOpenNotifyBodyRequestVo bodyRequestVo;

   @XmlElement(name = "reqHeader")
    public AccountOpenNotifyHeadRequestVo getHeadRequestVo() {
        return headRequestVo;
    }

    @XmlElement(name = "reqBody")
    public AccountOpenNotifyBodyRequestVo getBodyRequestVo() {
        return bodyRequestVo;
    }
}
