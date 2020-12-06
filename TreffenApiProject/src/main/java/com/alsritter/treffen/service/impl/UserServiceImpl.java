package com.alsritter.treffen.service.impl;

import com.alsritter.treffen.common.ServiceErrorResultEnum;
import com.alsritter.treffen.common.exception.MyWarnException;
import com.alsritter.treffen.entity.TbUser;
import com.alsritter.treffen.mapper.TbUserMapper;
import com.alsritter.treffen.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author alsritter
 * @version 1.0
 **/
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
    private final TbUserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public TbUser find(String userName) {
        TbUser tbUser = userMapper.selectByUserNameTbUser(userName);
        if (tbUser == null) {
            throw new MyWarnException(ServiceErrorResultEnum.NOT_FOUND);
        }

        return tbUser;
    }

    @Override
    public boolean check(String currentPassword, String password) {
        return this.bCryptPasswordEncoder.matches(currentPassword,password);
    }
}
