package com.alsritter.treffen.service;

import com.alsritter.treffen.entity.User;

public interface UserService {
    User find(String userName);
    boolean check(User user);
}
