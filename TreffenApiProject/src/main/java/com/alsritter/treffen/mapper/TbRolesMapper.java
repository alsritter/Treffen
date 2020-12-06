package com.alsritter.treffen.mapper;

import com.alsritter.treffen.entity.TbRoles;

public interface TbRolesMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(TbRoles record);

    int insertSelective(TbRoles record);

    TbRoles selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(TbRoles record);

    int updateByPrimaryKey(TbRoles record);
}