package com.alsritter.treffen.controller;

import com.alsritter.treffen.common.util.ResultGeneratorUtils;
import com.alsritter.treffen.controller.vo.Meeting;
import com.alsritter.treffen.controller.vo.Result;
import com.alsritter.treffen.entity.TbMeeting;
import com.alsritter.treffen.service.MeetingService;
import com.alsritter.treffen.service.dto.CreateMeetingRequest;
import com.alsritter.treffen.service.dto.UpdateMeetingRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 处理会议相关的事务
 *
 * @author alsritter
 * @version 1.0
 **/
@Api(tags = "会议相关请求")
@RequestMapping("/meeting")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MeetingController {

    private final MeetingService meetingService;

    @ApiOperation("取得已经完成的会议")
    @PreAuthorize("hasAnyRole('ROLE_MANAGER','ROLE_ADMIN')")
    @GetMapping("/getAllHistoryMeeting")
    public ResponseEntity<Result<List<Meeting>>> getAllHistoryMeeting() {
        List<Meeting> meetings =  meetingService.getAllHistoryMeeting();
        return ResponseEntity.ok().body(ResultGeneratorUtils.genSuccessResult(meetings));
    }

    @ApiOperation("取得当前还未完成的会议")
    @PreAuthorize("hasAnyRole('ROLE_MANAGER','ROLE_ADMIN')")
    @GetMapping("/getAllStartMeeting")
    public ResponseEntity<Result<List<Meeting>>> getAllStartMeeting() {
        List<Meeting> meetings =  meetingService.getAllStartMeeting();
        return ResponseEntity.ok().body(ResultGeneratorUtils.genSuccessResult(meetings));
    }

    @ApiOperation("结束当前会议")
    @PreAuthorize("hasAnyRole('ROLE_MANAGER','ROLE_ADMIN')")
    @PutMapping("/endMeeting/{meetingId}")
    public ResponseEntity<Result<String>> endMeeting(
            @ApiParam("会议的编号") @PathVariable Integer meetingId
    ) {
        meetingService.endMeeting(meetingId);
        return ResponseEntity.ok().body(ResultGeneratorUtils.genSuccessResult());
    }

    @ApiOperation("修改会议的内容")
    @PreAuthorize("hasAnyRole('ROLE_MANAGER','ROLE_ADMIN')")
    @PutMapping("/updateMeeting/{meetingId}")
    public ResponseEntity<Result<String>> updateMeeting(
            @ApiParam("会议的编号") @PathVariable Integer meetingId,
            @ApiParam("会议的内容") @RequestBody UpdateMeetingRequest recordDesc
    ) {
        meetingService.updateMeeting(meetingId, recordDesc );
        return ResponseEntity.ok().body(ResultGeneratorUtils.genSuccessResult());
    }

    @ApiOperation("创建一个会议")
    @PreAuthorize("hasAnyRole('ROLE_MANAGER','ROLE_ADMIN')")
    @PostMapping("/createMeeting")
    public ResponseEntity<Result<String>> createMeeting(
            @ApiParam("创建会议的参数") @RequestBody CreateMeetingRequest meeting) {
        meetingService.createMeeting(meeting);
        return ResponseEntity.ok().body(ResultGeneratorUtils.genSuccessResult());
    }
}
