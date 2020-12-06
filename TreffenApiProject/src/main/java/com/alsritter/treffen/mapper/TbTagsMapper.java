package com.alsritter.treffen.mapper;

import com.alsritter.treffen.entity.TbTags;

public interface TbTagsMapper {
    int deleteByPrimaryKey(Integer tagId);

    int insert(TbTags record);

    int insertSelective(TbTags record);

    TbTags selectByPrimaryKey(Integer tagId);

    int updateByPrimaryKeySelective(TbTags record);

    int updateByPrimaryKey(TbTags record);
}