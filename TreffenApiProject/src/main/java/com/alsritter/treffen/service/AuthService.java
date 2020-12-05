package com.alsritter.treffen.service;

import com.alsritter.treffen.controller.vo.LoginRequest;

public interface AuthService {
    String getToken(LoginRequest loginRequest);
    void deleteTokenFromRedis();
}
