package com.alsritter.treffen.mapper;

import com.alsritter.treffen.entity.TbMenuItemGroup;

public interface TbMenuItemGroupMapper {
    int deleteByPrimaryKey(Integer groupId);

    int insert(TbMenuItemGroup record);

    int insertSelective(TbMenuItemGroup record);

    TbMenuItemGroup selectByPrimaryKey(Integer groupId);

    int updateByPrimaryKeySelective(TbMenuItemGroup record);

    int updateByPrimaryKey(TbMenuItemGroup record);
}