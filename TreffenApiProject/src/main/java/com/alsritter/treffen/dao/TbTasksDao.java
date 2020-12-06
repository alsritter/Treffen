package com.alsritter.treffen.dao;

import com.alsritter.treffen.entity.TbTasks;

public interface TbTasksDao {
    int deleteByPrimaryKey(Integer deptId);

    int insert(TbTasks record);

    int insertSelective(TbTasks record);

    TbTasks selectByPrimaryKey(Integer deptId);

    int updateByPrimaryKeySelective(TbTasks record);

    int updateByPrimaryKey(TbTasks record);
}