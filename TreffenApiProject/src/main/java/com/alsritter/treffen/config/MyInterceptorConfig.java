package com.alsritter.treffen.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 这里添加自定义的拦截器
 *
 * @author alsritter
 * @version 1.0
 **/
@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer {

    // 添加拦截器到 Spring MVC 拦截器链 里面
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截所有路径  /** 表示这个请求下的所有请求 /* 只拦截一级请求
        // registry.addInterceptor(authorizationImageCodeInterceptor()).addPathPatterns("/**");
    }
}
