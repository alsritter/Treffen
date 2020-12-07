package com.alsritter.treffen.config.handler;

import com.alsritter.treffen.common.ServiceErrorResultEnum;
import com.alsritter.treffen.controller.vo.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用来解决认证过的用户访问无权限资源时的异常
 * 注意：
 * AuthenticationEntryPoint 用来解决匿名用户访问无权限资源时的异常
 * AccessDeniedHandler 用来解决认证过的用户访问无权限资源时的异常
 *
 * @author alsritter
 * @version 1.0
 **/
@Slf4j
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    /**
     * 当用户尝试访问需要权限才能的 REST 资源而权限不足的时候，
     * 将调用此方法发送 403 响应以及错误信息
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        PrintWriter out = null;
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(Result.<String>builder()
                .code(ServiceErrorResultEnum.NOT_ENOUGH_PERMISSIONS.getResultCode())
                .message(ServiceErrorResultEnum.NOT_ENOUGH_PERMISSIONS.getResultMsg())
                .build());

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
        log.warn(accessDeniedException.getMessage());
    }
}

