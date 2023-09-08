package com.imooc.ecommerce.advice;

import com.imooc.ecommerce.anno.IgnoreResponseAdvice;
import com.imooc.ecommerce.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * <h1>实现统一响应</h1>
 * 这里泛型只能是Object
 * ResponseBodyAdvice能对所有response进行拦截统一返回
 * value = "com.imooc.ecommerce"限制生效范围
 */
@RestControllerAdvice(value = "com.imooc.ecommerce")
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {

    /**
     * <h1>判断是否需要对响应进行处理</h1>
     * 默认是返回的false，不需要处理
     * 获取方法对应的controller类
     *
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    @SuppressWarnings("all")
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        if (methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }
        if (methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }

        return true;
    }

    /**
     * 在返回给客户端前还可以做一些事
     * 默认是不做任何处理
     *
     * @param o
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */
    @Override
    @SuppressWarnings("all")
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        // o就是响应的对象
        // 定义最终的返回对象
        CommonResponse<Object> response = new CommonResponse<>(0, "");
        if (o == null) {
            return response;
        } else if (o instanceof CommonResponse) {
            // 如果本来就是CommonResponse类型，就对response进行赋值
            response = (CommonResponse<Object>) o;
        } else {
            response.setData(0);
        }
        return response;
    }
}
