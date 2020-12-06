package com.alsritter.treffen.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * 封装了登陆的请求参数
 *
 * @author alsritter
 * @version 1.0
 **/
@Data
public class LoginRequest implements Serializable {
    @NotEmpty(message = "验证码不能为空")
    @ApiModelProperty(value = "验证码", required = true)
    private String verify;
    @NotEmpty(message = "唯一标识码不能为空")
    @ApiModelProperty(value = "唯一标识码", required = true)
    private String uuid;
    @NotEmpty(message = "登录名不能为空")
    @ApiModelProperty(value = "登录名", required = true)
    private String username;
    @NotEmpty(message = "密码不能为空")
    @ApiModelProperty(value = "密码", required = true)
    private String password;
    @NotEmpty(message = "rememberMe 不能为空")
    @ApiModelProperty(value = "记住我的选项", required = true)
    private Boolean rememberMe;
}
