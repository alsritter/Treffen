package com.alsritter.treffen.controller;

import com.alsritter.treffen.common.exception.*;
import com.alsritter.treffen.common.ConstantKit;
import com.alsritter.treffen.common.SecurityConstants;
import com.alsritter.treffen.common.ServiceErrorResultEnum;
import com.alsritter.treffen.service.dto.LoginRequest;
import com.alsritter.treffen.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alsritter
 * @version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(tags = "认证")
public class AuthController {

    private final AuthService authService;
    private final StringRedisTemplate stringTemplate;

    @PostMapping("/login")
    @ApiOperation("登录")
    public ResponseEntity<Void> login(@ApiParam("登陆的参数") @RequestBody LoginRequest loginRequest) {
        String verifyCode = loginRequest.getVerify();
        String uuid = loginRequest.getUuid();
        String previousVCode = stringTemplate.opsForValue().get(ConstantKit.IMAGE_CODE + uuid);

        // 先验证这个 uuid 是否存在
        if (previousVCode == null) {
            throw new MyWarnException(ServiceErrorResultEnum.VERIFY_CODE_TIMEOUT_OR_NOT_EXIST);
        }

        // 再判断验证码是否正确
        if (!previousVCode.trim().equals(verifyCode)) {
            throw new MyWarnException(ServiceErrorResultEnum.VERIFY_CODE_CREATE_ERROR);
        }

        String token = authService.getToken(loginRequest);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(SecurityConstants.TOKEN_HEADER, token);
        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }
}
