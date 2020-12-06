package com.alsritter.treffen.mapper;

import com.alsritter.treffen.entity.TbUser;

public interface TbUserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    TbUser selectByUserNameTbUser(String username);

    TbUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);
}