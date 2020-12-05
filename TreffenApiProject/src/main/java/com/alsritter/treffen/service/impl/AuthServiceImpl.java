package com.alsritter.treffen.service.impl;

import com.alsritter.treffen.controller.vo.LoginRequest;
import com.alsritter.treffen.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author alsritter
 * @version 1.0
 **/
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthServiceImpl implements AuthService {
    @Override
    public String getToken(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public void deleteTokenFromRedis() {

    }
}
