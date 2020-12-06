package com.alsritter.treffen.mapper;

import com.alsritter.treffen.entity.TbMenuItem;

public interface TbMenuItemMapper {
    int deleteByPrimaryKey(Integer itemId);

    int insert(TbMenuItem record);

    int insertSelective(TbMenuItem record);

    TbMenuItem selectByPrimaryKey(Integer itemId);

    int updateByPrimaryKeySelective(TbMenuItem record);

    int updateByPrimaryKey(TbMenuItem record);
}