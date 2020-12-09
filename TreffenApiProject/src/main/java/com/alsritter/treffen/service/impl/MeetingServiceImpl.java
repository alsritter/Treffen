package com.alsritter.treffen.service.impl;

import com.alsritter.treffen.common.ServiceErrorResultEnum;
import com.alsritter.treffen.common.exception.MyErrorException;
import com.alsritter.treffen.common.util.CurrentUserUtils;
import com.alsritter.treffen.entity.TbMeeting;
import com.alsritter.treffen.entity.TbUser;
import com.alsritter.treffen.mapper.TbMeetingMapper;
import com.alsritter.treffen.service.MeetingService;
import com.alsritter.treffen.service.dto.Meeting;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author alsritter
 * @version 1.0
 **/
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MeetingServiceImpl implements MeetingService {

    private final TbMeetingMapper meetingMapper;
    private final CurrentUserUtils currentUserUtils;

    @Override
    @Transactional
    public boolean createMeeting(Meeting meeting) {
        TbMeeting tbMeeting = new TbMeeting();
        TbUser currentUser = currentUserUtils.getCurrentUser();

        tbMeeting.setRecordDesc(meeting.getRecordDesc());
        tbMeeting.setStartTime(meeting.getStartTime());
        tbMeeting.setRecordType(meeting.getRecordType());
        tbMeeting.setHostId(currentUser.getUserId());
        int isOk = meetingMapper.insert(tbMeeting);
        if (isOk < 1) {
            throw new MyErrorException(ServiceErrorResultEnum.INTERNAL_SERVER_ERROR);
        }

        return true;
    }
}
