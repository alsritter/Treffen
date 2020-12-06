package com.alsritter.treffen.dao;

import com.alsritter.treffen.entity.TbMenuItemPrivileges;

public interface TbMenuItemPrivilegesDao {
    int deleteByPrimaryKey(Integer deptId);

    int insert(TbMenuItemPrivileges record);

    int insertSelective(TbMenuItemPrivileges record);

    TbMenuItemPrivileges selectByPrimaryKey(Integer deptId);

    int updateByPrimaryKeySelective(TbMenuItemPrivileges record);

    int updateByPrimaryKey(TbMenuItemPrivileges record);
}