package com.alsritter.treffen.mapper;

import com.alsritter.treffen.entity.TbRoles;
import com.alsritter.treffen.entity.UserRoleKey;

import java.util.List;

public interface UserRoleMapper {
    List<TbRoles> selectByUserId(Integer userId);

    int deleteByPrimaryKey(UserRoleKey key);

    int insert(UserRoleKey record);

    int insertSelective(UserRoleKey record);
}