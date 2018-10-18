package com.huang.study.common.tips;

/**
 * 返回给前台的提示（最终转化为json形式）
 */
public abstract class Tip<T> {

    // 响应代码
    protected String code;
    // 响应消息
    protected String msg;
    // 是否成功
    protected Boolean success;
    // 响应数据
    protected T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
