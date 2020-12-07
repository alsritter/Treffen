package com.alsritter.treffen.mapper;

import com.alsritter.treffen.entity.TbRoles;
import com.alsritter.treffen.entity.UserRoleKey;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface UserRoleMapper extends BaseMapper<UserRoleKey> {
    List<UserRoleKey> selectByUserId(Integer userId);

    List<TbRoles> selectByRoleIdList(List<UserRoleKey> roleIdList);
}