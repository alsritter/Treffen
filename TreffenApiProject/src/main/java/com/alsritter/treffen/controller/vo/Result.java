package com.alsritter.treffen.controller.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 响应的模板
 *
 * @author alsritter
 * @version 1.0
 **/
@Data
@Builder
public class Result<T> {
    /**
     * 业务码，比如成功、失败、权限不足等 code，可自行定义
     */
    @ApiModelProperty("返回码")
    private Integer code;
    /**
     * 返回信息，后端在进行业务处理后返回给前端一个提示信息，可自行定义
     */
    @ApiModelProperty("返回信息")
    private String message;
    /**
     * 数据结果，泛型，可以是列表、单个对象、数字、布尔值等
     */
    @ApiModelProperty("返回数据")
    private T data;
}
