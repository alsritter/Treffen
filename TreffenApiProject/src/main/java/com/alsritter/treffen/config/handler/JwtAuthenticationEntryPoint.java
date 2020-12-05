package com.alsritter.treffen.config.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用来解决匿名用户访问需要权限才能访问的资源时的异常
 *
 * AuthenticationEntryPoint 是 Spring Security Web一个概念模型接口，
 * 顾名思义，他所建模的概念是:“认证入口点” 它在用户请求处理过程中遇到认证异常时，
 * 被 ExceptionTranslationFilter 用于开启特定认证方案(authentication schema)的认证流程。
 *
 *
 * @author alsritter
 * @version 1.0
 **/
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    /**
     * 当用户尝试访问需要权限才能的 REST 资源而不提供 Token 或者 Token 错误或者过期时，
     * 将调用此方法发送 401 响应以及错误信息
     *
     * @param request 遇到了认证异常 authException 用户请求
     * @param response 是将要返回给客户的响应，方法 commence 实现,也就是相应的认证方案逻辑会修改 response 并返回给用户引导用户进入认证流程。
     * @param authException 具体认证的错误
     * @throws IOException 发送过程的错误
     */
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
    }
}
