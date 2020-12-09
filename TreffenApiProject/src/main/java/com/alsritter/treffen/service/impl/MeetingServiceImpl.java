package com.alsritter.treffen.service.impl;

import com.alsritter.treffen.common.DataBaseConstants;
import com.alsritter.treffen.common.ServiceErrorResultEnum;
import com.alsritter.treffen.common.exception.MyErrorException;
import com.alsritter.treffen.common.util.CurrentUserUtils;
import com.alsritter.treffen.common.util.JacksonUtil;
import com.alsritter.treffen.controller.vo.Meeting;
import com.alsritter.treffen.entity.TbDept;
import com.alsritter.treffen.entity.TbMeeting;
import com.alsritter.treffen.entity.TbUser;
import com.alsritter.treffen.mapper.TbDeptMapper;
import com.alsritter.treffen.mapper.TbMeetingMapper;
import com.alsritter.treffen.mapper.TbUserMapper;
import com.alsritter.treffen.service.MeetingService;
import com.alsritter.treffen.service.dto.CreateMeetingRequest;
import com.alsritter.treffen.service.dto.UpdateMeetingRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author alsritter
 * @version 1.0
 **/
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MeetingServiceImpl implements MeetingService {

    private final TbMeetingMapper meetingMapper;
    private final TbUserMapper userMapper;
    private final TbDeptMapper deptMapper;
    private final CurrentUserUtils currentUserUtils;
    private final StringRedisTemplate stringTemplate;

    @Override
    @Transactional
    public void createMeeting(CreateMeetingRequest meeting) {
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
    }

    @Override
    @Transactional
    public void endMeeting(Integer meetingId) {
        UpdateWrapper<TbMeeting> tbMeetingUpdateWrapper = new UpdateWrapper<>();
        tbMeetingUpdateWrapper.eq("meeting_id", meetingId).set("end_time", new Date());
        meetingMapper.update(null, tbMeetingUpdateWrapper);
    }

    /**
     * 这是一个很费的操作，所以需要把数据存到 Redis 里面，十分钟过期，
     * 直到下次请求过来请求时 Redis 里面找不到再去查询数据库
     *
     * @return List<Meeting>
     */
    @Override
    public List<Meeting> getAllStartMeeting() {
        // 先检查 Redis 里面有没有
        String json = stringTemplate.opsForValue().get(DataBaseConstants.ALL_START_MEETING);


        // 先验证这个 json 是否存在，不存再查询
        if (json == null) {
            QueryWrapper<TbMeeting> tbMeetingQueryWrapper = new QueryWrapper<>();
            tbMeetingQueryWrapper.isNull("end_time");
            List<TbMeeting> tbMeetings = meetingMapper.selectList(tbMeetingQueryWrapper);
            List<Meeting> meetings = new ArrayList<>();

            tbMeetings.forEach(x -> {
                Integer hostId = x.getHostId();
                TbUser tbUser = userMapper.selectById(hostId);
                TbDept tbDept = deptMapper.selectById(tbUser.getDeptId());

                Meeting meeting = new Meeting();
                meeting.setMeetingId(x.getMeetingId());
                meeting.setRecordType(x.getRecordType());
                meeting.setUserEId(tbUser.getUserName());
                meeting.setUserName(tbUser.getTrueName());
                meeting.setEmail(tbUser.getEmail());
                meeting.setJob(tbUser.getJob());
                meeting.setPhone(tbUser.getPhone());

                meeting.setDeptLocation(tbDept.getDeptLocation());
                meeting.setDeptName(tbDept.getDeptName());

                meetings.add(meeting);

            });
            // 先转成 JSON 存到 Redis 里面
            String str = JacksonUtil.toJSon(meetings);
            //将验证码存到redis
            stringTemplate.opsForValue().set(DataBaseConstants.ALL_START_MEETING, str);
            // 设置过期时间
            stringTemplate.expire(DataBaseConstants.ALL_START_MEETING,
                    DataBaseConstants.ALL_START_MEETING_TIME, TimeUnit.SECONDS);
            return meetings;
        } else {
            // json 转成 List
            return JacksonUtil.readValue(json, new TypeReference<List<Meeting>>() {
            });
        }
    }

    @Override
    public List<Meeting> getAllHistoryMeeting() {
        return null;
    }

    @Override
    public void updateMeeting(Integer meetingId, UpdateMeetingRequest recordDesc) {

    }
}
