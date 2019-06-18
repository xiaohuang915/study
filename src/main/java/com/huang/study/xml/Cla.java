package com.huang.study.xml;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2019/6/18 16:25
 */
@Setter
@Getter
@XmlRootElement(name = "cla")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Tea.class,Stu.class})
public class Cla<T,R> {
    @XmlAnyElement(lax = true)
    private T ss;

    @XmlAnyElement(lax = true)
    private R tt;


}
