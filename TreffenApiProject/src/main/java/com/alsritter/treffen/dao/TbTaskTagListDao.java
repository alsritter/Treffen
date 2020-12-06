package com.alsritter.treffen.dao;

import com.alsritter.treffen.entity.TbTaskTagList;

public interface TbTaskTagListDao {
    int deleteByPrimaryKey(Integer deptId);

    int insert(TbTaskTagList record);

    int insertSelective(TbTaskTagList record);

    TbTaskTagList selectByPrimaryKey(Integer deptId);

    int updateByPrimaryKeySelective(TbTaskTagList record);

    int updateByPrimaryKey(TbTaskTagList record);
}