package com.huang.study.method;

import com.huang.study.common.util.IdGenerator;
import org.apache.poi.ss.formula.functions.T;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020-09-12 09:53
 */
public abstract class AbstractBiz {


    public final <T> T inwork(Object req, Class<T> clz) {
        String uid = IdGenerator.getId();
        saveRequest(req, uid);
        T response = getResponse(req, clz);
        saveResponse(response, uid);
        return response;
    }

    private <T> T getResponse(Object req, Class<T> clz) {

        return null;
    }

    abstract void saveRequest(Object req, String uid);


    abstract void saveResponse(Object res, String uid);
}
