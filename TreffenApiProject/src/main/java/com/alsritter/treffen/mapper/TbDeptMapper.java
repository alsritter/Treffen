package com.alsritter.treffen.mapper;

import com.alsritter.treffen.entity.TbDept;

public interface TbDeptMapper {
    int deleteByPrimaryKey(Integer deptId);

    int insert(TbDept record);

    int insertSelective(TbDept record);

    TbDept selectByPrimaryKey(Integer deptId);

    int updateByPrimaryKeySelective(TbDept record);

    int updateByPrimaryKey(TbDept record);
}