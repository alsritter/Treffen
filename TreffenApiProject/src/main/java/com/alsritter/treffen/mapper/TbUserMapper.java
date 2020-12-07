package com.alsritter.treffen.mapper;

import com.alsritter.treffen.entity.TbUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface TbUserMapper extends BaseMapper<TbUser> {
    TbUser selectByUserNameTbUser(String username);
}