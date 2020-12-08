package com.alsritter.treffen.controller;

import com.alsritter.treffen.common.util.ResultGeneratorUtils;
import com.alsritter.treffen.controller.vo.Menu;
import com.alsritter.treffen.controller.vo.Result;
import com.alsritter.treffen.service.MenusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    private final MenusService menusService;

    @ApiOperation("根据")
    @GetMapping("/getMenu")
    public ResponseEntity<Result<List<Menu>>> getMenu() {
        return ResponseEntity
                .ok()
                .body(
                        ResultGeneratorUtils.genSuccessResult(menusService.getMenus())
                );
    }
}
