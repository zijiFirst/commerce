package com.imooc.ecommerce.advice;

import com.imooc.ecommerce.vo.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * <h1>全局异常捕获处理</h1>
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = Exception.class)  // 能对出现的异常进行拦截  下面的两个参数由这个注解传入  拦截后就不会返回给客户端，而是由我们拦截进行统一异常处理
    public CommonResponse<String> handlerCommonException(HttpServletRequest req, Exception ex) {
        CommonResponse<String> response = new CommonResponse<>(-1, "business error");
        response.setData(ex.getMessage());
        log.error("commerce service has error:[{}]", ex.getMessage(), ex);
        return response;
    }
}
