package com.alsritter.treffen.controller;

import com.alsritter.treffen.common.util.ResultGeneratorUtils;
import com.alsritter.treffen.controller.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alsritter
 * @version 1.0
 **/
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/temp")
@Api(tags = "测试 API")
public class TempController {

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @ApiOperation("说你好，需要 ADMIN 权限")
    @GetMapping("/hello")
    public ResponseEntity<Result<String>> sayHello() {
        return ResponseEntity
                .ok()
                .body(ResultGeneratorUtils.genSuccessResult("你好，你能看到这条内容表示权限系统差不多了"));
    }
}
