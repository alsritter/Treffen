package com.alsritter.treffen.mapper;

import com.alsritter.treffen.entity.TbTasks;

public interface TbTasksMapper {
    int deleteByPrimaryKey(Integer taskId);

    int insert(TbTasks record);

    int insertSelective(TbTasks record);

    TbTasks selectByPrimaryKey(Integer taskId);

    int updateByPrimaryKeySelective(TbTasks record);

    int updateByPrimaryKey(TbTasks record);
}