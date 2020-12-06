package com.alsritter.treffen.dao;

import com.alsritter.treffen.entity.TbRoles;

public interface TbRolesDao {
    int deleteByPrimaryKey(Integer deptId);

    int insert(TbRoles record);

    int insertSelective(TbRoles record);

    TbRoles selectByPrimaryKey(Integer deptId);

    int updateByPrimaryKeySelective(TbRoles record);

    int updateByPrimaryKey(TbRoles record);
}