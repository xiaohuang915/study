package com.huang.study.common.exception;

/**
 * 所有业务异常的枚举
 */
public enum BizExceptionEnum {

    /**
     * token异常
     */
    TOKEN_EXPIRED("700", "token过期,请重新登陆获取"),
    TOKEN_ERROR("701", "token验证失败"),

    /**
     * 签名异常
     */
    SIGN_ERROR("702", "签名验证失败"),

    /**
     * 其他
     */
    AUTH_REQUEST_ERROR("400", "账号密码错误");

    BizExceptionEnum(String code, String message) {
        this.friendlyCode = code;
        this.friendlyMsg = message;
    }

    private String friendlyCode;

    private String friendlyMsg;

    public String getCode() {
        return friendlyCode;
    }

    public void setCode(String code) {
        this.friendlyCode = code;
    }

    public String getMessage() {
        return friendlyMsg;
    }

    public void setMessage(String message) {
        this.friendlyMsg = message;
    }

}
