package com.huang.study.common.tips;

/**
 * 返回给前台的错误提示
 */
public class ErrorTip<T> extends Tip<T> {

    public ErrorTip(String code, String message, T data) {
        super();
        this.code = code;
        this.msg = message;
        this.data = data;
        this.success = Boolean.FALSE;
    }
}
