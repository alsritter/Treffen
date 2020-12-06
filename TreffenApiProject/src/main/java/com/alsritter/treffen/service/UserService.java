package com.alsritter.treffen.service;

import com.alsritter.treffen.entity.TbUser;

public interface UserService {
    TbUser find(String userName);
    boolean check(TbUser user);
}
