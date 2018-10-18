package com.huang.study.common.exception;

import com.huang.study.common.tips.ErrorTip;
import com.huang.study.common.tips.Tip;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HPC
 * @date 2018年8月14日
 * @Description: 全局异常拦截
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Tip<Object> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        StackTraceElement[] stackTrace = e.getStackTrace();
        String message = new StringBuilder().append("  ，出错类名是: ").append(stackTrace[0].getFileName()).append("，出错方法是: ")
                .append(stackTrace[0].getMethodName()).append("，出错的行数是: ").append(stackTrace[0].getLineNumber())
                .append("，访问的url是: ").append(req.getServletPath()).toString();
        if (e instanceof BussinessException) {
            BussinessException exception = (BussinessException) e;
            logger.error("业务异常 Exception: {}", exception.getMessage() + message);
            return new ErrorTip<>(exception.getCode(), "业务异常", exception.getMessage() + message);
        }else if(e instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException)e;
            List<ObjectError> allErrors = exception.getBindingResult().getAllErrors();
            StringBuilder stringBuilder = new StringBuilder();
            for (ObjectError allError : allErrors) {
                stringBuilder.append(allError.getDefaultMessage()).append(",");
            }
            return new ErrorTip<>("-1", "参数校验异常", stringBuilder.toString());
        }
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        logger.error("系统异常 Exception: {}", e.getMessage() + message);
        logger.error(sw.toString());
        if (pw!=null){
            pw.close();
        }
        if (sw!=null){
            sw.close();
        }
        return new ErrorTip<>("-1", "系统异常", e.getMessage() + message);
    }

    /**
     * @Comments: 是否为空(字符串 | 集合 | 数组 : ! = null or size > 0, 数字 > 0, boolean : true)
     * @param: 不定参数(不定类型)
     * @return: boolean true不为空，false为空
     */
    @SuppressWarnings("rawtypes")
    public static boolean toEmpty(Object... obj) {
        if (obj != null) {
            for (Object o : obj) {
                if (o != null) {
                    if (o instanceof String && !o.equals("")) {//传值为字符串    不能为""
                        continue;
                    } else if (o instanceof Number) {//传值为数字  && ((Number) o).doubleValue() > 0
                        continue;
                    } else if (o instanceof Boolean && (Boolean) o) {//传值为 boolean 不能为false
                        continue;
                    } else if (o instanceof Collection && !((Collection) o).isEmpty()) {//传值为Collection 长度 > 0
                        continue;
                    } else if (o instanceof Map && !((Map) o).isEmpty()) {//传值为map 长度 > 0
                        continue;
                    } else if (o instanceof Object[] && ((Object[]) o).length > 0) {//传值为数组 长度 > 0
                        continue;
                    } else {//否则  为没有值
                        return false;
                    }
                } else {//否则  为没有值
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}

