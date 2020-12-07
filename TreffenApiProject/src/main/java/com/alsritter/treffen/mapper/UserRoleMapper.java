package com.alsritter.treffen.mapper;

import com.alsritter.treffen.entity.TbRoles;
import com.alsritter.treffen.entity.UserRoleKey;

import java.util.List;

public interface UserRoleMapper {
    List<UserRoleKey> selectByUserId(Integer userId);

    List<TbRoles> selectByRoleIdList(List<UserRoleKey> roleIdList);

    int deleteByPrimaryKey(UserRoleKey key);

    int insert(UserRoleKey record);

    int insertSelective(UserRoleKey record);
}