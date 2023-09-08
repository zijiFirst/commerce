package com.imooc.ecommerce.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <h1>忽略统一响应注解定义</h1>
 * @Target下面定义源注解，对于注解进行属性标识
 * @Retention标识这个注解保留到什么时候,保留到运行时
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreResponseAdvice {
    /**
     * 不返回统一响应
      */
}
