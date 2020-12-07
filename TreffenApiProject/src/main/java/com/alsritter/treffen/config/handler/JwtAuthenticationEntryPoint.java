package com.alsritter.treffen.config.handler;

import com.alsritter.treffen.common.ServiceErrorResultEnum;
import com.alsritter.treffen.controller.vo.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用来解决匿名用户(就是未登录的)访问需要权限才能访问的资源时的异常
 * 注意：
 * AuthenticationEntryPoint 用来解决匿名用户访问无权限资源时的异常
 * AccessDeniedHandler 用来解决认证过的用户访问无权限资源时的异常
 *
 * @author alsritter
 * @version 1.0
 **/
@Slf4j
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    /**
     * 当用户尝试访问需要权限才能的 REST 资源而不提供 Token 或者 Token 错误或者过期时，
     * 将调用此方法发送 401 响应以及错误信息
     *
     * @param request       遇到了认证异常 authException 用户请求
     * @param response      是将要返回给客户的响应，方法 commence 实现,也就是相应的认证方案逻辑会修改 response 并返回给用户引导用户进入认证流程。
     * @param authException 具体认证的错误
     * @throws IOException 发送过程的错误
     */
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        log.warn(authException.getMessage());

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(Result.<String>builder()
                .code(ServiceErrorResultEnum.NOT_ENOUGH_PERMISSIONS.getResultCode())
                .message(ServiceErrorResultEnum.NOT_ENOUGH_PERMISSIONS.getResultMsg())
                .build());


        PrintWriter out = null;
        try {
            response.setStatus(ServiceErrorResultEnum.NOT_ENOUGH_PERMISSIONS.getResultCode());
            response.setContentType("application/json;charset=utf-8");
            out = response.getWriter();
            out.println(json);
        } finally {
            if (null != out) {
                out.flush();
                out.close();
            }
        }
    }
}
