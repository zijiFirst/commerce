package com.imooc.ecommerce.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <h1>通用响应对象定义</h1>
 * {
 * "id":1,
 * "name":"hu"
 * }
 * 上面那样比较麻烦，用下面通用返回的
 * {
 * "code":0,
 * "message":"",
 * "data":{} 通常定义成泛型
 * }
 */
@Data
@NoArgsConstructor  // 无参构造函数
@AllArgsConstructor  // 全参构造函数
public class CommonResponse<T> implements Serializable {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String messagae;

    /**
     * 泛型响应数据
     */
    private T data;

    public CommonResponse(Integer code, String message) {
        this.code = code;
        this.messagae = message;
    }
}
