package com.alsritter.treffen.service.impl;

import com.alsritter.treffen.common.util.CurrentUserUtils;
import com.alsritter.treffen.controller.dto.LoginRequest;
import com.alsritter.treffen.service.AuthService;
import com.alsritter.treffen.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

/**
 * @author alsritter
 * @version 1.0
 **/
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final StringRedisTemplate stringRedisTemplate;
    private final CurrentUserUtils currentUserUtils;

    @Override
    public String getToken(LoginRequest loginRequest) {
        TbUser user = userService.find(loginRequest.getUsername());
        if (userService.check(user)) {
            throw new BadCredentialsException("The user name or password is not correct.");
        }

        return null;
    }

    @Override
    public void deleteTokenFromRedis() {

    }
}
