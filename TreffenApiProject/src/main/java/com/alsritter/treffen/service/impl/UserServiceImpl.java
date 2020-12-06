package com.alsritter.treffen.service.impl;

import com.alsritter.treffen.entity.User;
import com.alsritter.treffen.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author alsritter
 * @version 1.0
 **/
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
    @Override
    public User find(String userName) {
        return null;
    }

    @Override
    public boolean check(User user) {
        return false;
    }
}
