package com.alsritter.treffen.dao;

import com.alsritter.treffen.entity.TbMenuItemGroup;

public interface TbMenuItemGroupDao {
    int deleteByPrimaryKey(Integer deptId);

    int insert(TbMenuItemGroup record);

    int insertSelective(TbMenuItemGroup record);

    TbMenuItemGroup selectByPrimaryKey(Integer deptId);

    int updateByPrimaryKeySelective(TbMenuItemGroup record);

    int updateByPrimaryKey(TbMenuItemGroup record);
}