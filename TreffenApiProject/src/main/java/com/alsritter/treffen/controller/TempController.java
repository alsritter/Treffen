package com.alsritter.treffen.controller;

import com.alsritter.treffen.common.util.CurrentUserUtils;
import com.alsritter.treffen.common.util.ResultGeneratorUtils;
import com.alsritter.treffen.controller.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @author alsritter
 * @version 1.0
 **/
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/temp")
@Api(tags = "测试 API")
public class TempController {

    private final CurrentUserUtils currentUserUtils;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @ApiOperation("说你好，需要 ADMIN 权限")
    @GetMapping("/hello")
    public ResponseEntity<Result<Collection<? extends GrantedAuthority>>> sayHello() {
        return ResponseEntity
                .ok()
                .body(ResultGeneratorUtils.genSuccessResult(currentUserUtils.getAuthorities()));
    }
}
