package com.alsritter.treffen.service.impl;

import com.alsritter.treffen.dao.TbUserDao;
import com.alsritter.treffen.entity.TbUser;
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
    private final TbUserDao userDao;

    @Override
    public TbUser find(String userName) {
        return null;
    }

    @Override
    public boolean check(TbUser user) {
        return false;
    }
}
