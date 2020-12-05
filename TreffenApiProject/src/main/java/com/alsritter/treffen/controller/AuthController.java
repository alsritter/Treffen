package com.alsritter.treffen.controller;

import com.alsritter.treffen.common.SecurityConstants;
import com.alsritter.treffen.config.annotation.AuthImageCode;
import com.alsritter.treffen.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author alsritter
 * @version 1.0
 **/
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(tags = "认证")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    @ApiOperation("登录")
    @AuthImageCode
    public ResponseEntity<Void> login(
            @ApiParam("登录名") @RequestParam String username,
            @ApiParam("密码") @RequestParam String password,
            @ApiParam("记住我的选项") @RequestParam Boolean rememberMe,
            @ApiParam("验证码") @RequestParam String verifyCode,
            @ApiParam("唯一标识码") @RequestParam String uuid) {
        String token = "temp_token";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(SecurityConstants.TOKEN_HEADER, token);
        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }
}
