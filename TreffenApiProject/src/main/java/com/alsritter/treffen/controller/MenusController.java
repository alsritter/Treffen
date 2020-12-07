package com.alsritter.treffen.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 关于菜单相关的请求在这里，主要就是不同权限的用户返回不同的菜单
 *
 * @author alsritter
 * @version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(tags = "菜单相关")
public class MenusController {
    //TODO: 动态权限菜单
}
