package com.huang.study.common.tips;

/**
 * 返回给前台的成功提示
 */
public class SuccessTip<T> extends Tip<T> {

    public SuccessTip(T t) {
        super.code = "200";
        super.msg = "操作成功";
        super.success = Boolean.TRUE;
        super.data = t;
    }

}
