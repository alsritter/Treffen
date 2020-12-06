package com.alsritter.treffen.dao;

import com.alsritter.treffen.entity.TbMeeting;

public interface TbMeetingDao {
    int deleteByPrimaryKey(Integer deptId);

    int insert(TbMeeting record);

    int insertSelective(TbMeeting record);

    TbMeeting selectByPrimaryKey(Integer deptId);

    int updateByPrimaryKeySelective(TbMeeting record);

    int updateByPrimaryKey(TbMeeting record);
}