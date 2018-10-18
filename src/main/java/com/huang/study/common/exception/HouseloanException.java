package com.huang.study.common.exception;

/**
 * 业务异常的封装
 *
 * @date 2016年11月12日 下午5:05:10
 */
public class HouseloanException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 7692495539282621634L;

    //友好提示的code码
    protected String friendlyCode;

    //友好提示
    protected String friendlyMsg;

    //业务异常跳转的页面
    protected String urlPath;

    public HouseloanException(String friendlyCode, String friendlyMsg, String urlPath) {
        this.setValues(friendlyCode, friendlyMsg, urlPath);
    }

    public HouseloanException(HouseloanExceptionEnum bizExceptionEnum) {
        this.setValues(bizExceptionEnum.getCode(), bizExceptionEnum.getMessage(), bizExceptionEnum.getUrlPath());
    }

    private void setValues(String friendlyCode, String friendlyMsg, String urlPath) {
        this.friendlyCode = friendlyCode;
        this.friendlyMsg = friendlyMsg;
        this.urlPath = urlPath;
    }

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

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }
}
