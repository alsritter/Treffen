package com.alsritter.treffen.controller;

import com.alsritter.treffen.common.util.ResultGeneratorUtils;
import com.alsritter.treffen.controller.vo.Result;
import com.alsritter.treffen.service.MeetingService;
import com.alsritter.treffen.service.dto.Meeting;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation("创建一个会议")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_MANAGER','ROLE_ADMIN')")
    @GetMapping("/createMeeting")
    public ResponseEntity<Result<String>> createMeeting(@ApiParam("创建会议的参数") @RequestBody Meeting meeting) {
        meetingService.createMeeting(meeting);
        return ResponseEntity.ok().body(ResultGeneratorUtils.genSuccessResult());
    }
}
