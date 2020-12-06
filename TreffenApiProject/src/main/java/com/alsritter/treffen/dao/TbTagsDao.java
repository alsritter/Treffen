package com.alsritter.treffen.dao;

import com.alsritter.treffen.entity.TbTags;

public interface TbTagsDao {
    int deleteByPrimaryKey(Integer deptId);

    int insert(TbTags record);

    int insertSelective(TbTags record);

    TbTags selectByPrimaryKey(Integer deptId);

    int updateByPrimaryKeySelective(TbTags record);

    int updateByPrimaryKey(TbTags record);
}