package com.alsritter.treffen.dao;

import com.alsritter.treffen.entity.TbMenuItem;

public interface TbMenuItemDao {
    int deleteByPrimaryKey(Integer deptId);

    int insert(TbMenuItem record);

    int insertSelective(TbMenuItem record);

    TbMenuItem selectByPrimaryKey(Integer deptId);

    int updateByPrimaryKeySelective(TbMenuItem record);

    int updateByPrimaryKey(TbMenuItem record);
}