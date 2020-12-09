package com.alsritter.treffen.service;

import com.alsritter.treffen.controller.vo.Meeting;
import com.alsritter.treffen.service.dto.CreateMeetingRequest;
import com.alsritter.treffen.service.dto.UpdateMeetingRequest;

import java.util.List;

public interface MeetingService {
    void createMeeting(CreateMeetingRequest meeting);

    void endMeeting(Integer meetingId);

    List<Meeting> getAllStartMeeting();

    List<Meeting> getAllHistoryMeeting();

    void updateMeeting(Integer meetingId, UpdateMeetingRequest recordDesc);
}
