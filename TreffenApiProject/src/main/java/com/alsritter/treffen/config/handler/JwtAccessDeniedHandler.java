package com.alsritter.treffen.config.handler;

import com.alsritter.treffen.common.ServiceErrorResultEnum;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用来解决认证过的用户访问无权限资源时的异常
 *
 * @author alsritter
 * @version 1.0
 **/
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    /**
     * 当用户尝试访问需要权限才能的 REST 资源而权限不足的时候，
     * 将调用此方法发送 403 响应以及错误信息
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        response.sendError(ServiceErrorResultEnum.NOT_ENOUGH_PERMISSIONS.getResultCode(), ServiceErrorResultEnum.NOT_ENOUGH_PERMISSIONS.getResultMsg());
    }
}

