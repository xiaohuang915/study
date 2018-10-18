package com.huang.study.common.exception;

/**
 * @Description 业务异常的封装
 */
public class BussinessException extends HouseloanException {

    /**
     *
     */
    private static final String CODE = "-1";
    private static final long serialVersionUID = -2142798283820076813L;

    public BussinessException(BizExceptionEnum bizExceptionEnum) {
        super(bizExceptionEnum.getCode(), bizExceptionEnum.getMessage(), "");
    }

    public BussinessException(String message) {
        super(CODE, message, "");
    }
}
