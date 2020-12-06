package com.alsritter.treffen.dao;

import com.alsritter.treffen.entity.TbMeetingAttendeeList;

public interface TbMeetingAttendeeListDao {
    int deleteByPrimaryKey(Integer deptId);

    int insert(TbMeetingAttendeeList record);

    int insertSelective(TbMeetingAttendeeList record);

    TbMeetingAttendeeList selectByPrimaryKey(Integer deptId);

    int updateByPrimaryKeySelective(TbMeetingAttendeeList record);

    int updateByPrimaryKey(TbMeetingAttendeeList record);
}