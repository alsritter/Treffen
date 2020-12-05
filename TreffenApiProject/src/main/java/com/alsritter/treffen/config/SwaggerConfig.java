package com.alsritter.treffen.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/**
 * 配置文档的信息
 *
 * @author alsritter
 * @version 1.0
 **/
@EnableKnife4j
@EnableOpenApi
@Configuration
@ComponentScan("com.alsritter.treffen.controller")
public class SwaggerConfig {
    @Bean
    public Docket docker(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("tempGroup01")
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.alsritter.treffen.controller"))
                .build();
    }

    private ApiInfo apiInfo(){
        Contact contact = new Contact("alsritter", "个人链接：https://alsritter.icu/", "alsritter1@gmail.com");

        return new ApiInfo(
                "Treffen API Documents", // 标题
                "Treffen 后端提供的 API 文档", // 描述
                "v0.0.1", // 版本
                "", // 组织链接
                contact, // 联系人信息
                "Apache 2.0", // 许可
                "", // 许可连接
                new ArrayList<>()// 扩展
        );
    }
}
