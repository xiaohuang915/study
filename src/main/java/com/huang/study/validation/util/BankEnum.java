package com.huang.study.validation.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/4/28 10:58
 */
@Getter
@AllArgsConstructor
public enum BankEnum {
    BOS("bos", Bos.class),
    ICBC("icbc", Icbc.class);
    private String code;
    private Class aClass;

    public static BankEnum getBank(String code) {
        for (BankEnum value : values()) {
            if (StringUtils.equals(value.getCode(), code)) {
                return value;
            }
        }
        return null;
    }
}
