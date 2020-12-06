package com.alsritter.treffen.mapper;

import com.alsritter.treffen.entity.TbMeeting;

public interface TbMeetingMapper {
    int deleteByPrimaryKey(Integer meetingId);

    int insert(TbMeeting record);

    int insertSelective(TbMeeting record);

    TbMeeting selectByPrimaryKey(Integer meetingId);

    int updateByPrimaryKeySelective(TbMeeting record);

    int updateByPrimaryKey(TbMeeting record);
}