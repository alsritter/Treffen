package com.alsritter.treffen.service;

import com.alsritter.treffen.controller.dto.LoginRequest;

public interface AuthService {
    String getToken(LoginRequest loginRequest);
    void deleteTokenFromRedis();
}
