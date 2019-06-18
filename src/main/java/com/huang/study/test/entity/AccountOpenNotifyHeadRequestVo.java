package com.huang.study.test.entity;

import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2019/6/10 10:41
 */
@Setter
public class AccountOpenNotifyHeadRequestVo implements Serializable {
    private static final long serialVersionUID = -4193690887654105146L;

    /**
     * 服务ID
     */
    private String serviceId;

    /**
     * 第三方系统编号
     */
    private String systemId;

    /**
     * 交易日期
     */
    private String traceDate;

    /**
     * 交易时间
     */
    private String traceTime;

    /**
     * 第三方系统流水号
     */
    private String traceSerial;

    @XmlElement(name = "serviceId")
    public String getServiceId() {
        return serviceId;
    }

    @XmlElement(name = "systemId")
    public String getSystemId() {
        return systemId;
    }

    @XmlElement(name = "traceDate")
    public String getTraceDate() {
        return traceDate;
    }

    @XmlElement(name = "traceTime")
    public String getTraceTime() {
        return traceTime;
    }

    @XmlElement(name = "traceSerial")
    public String getTraceSerial() {
        return traceSerial;
    }
}
