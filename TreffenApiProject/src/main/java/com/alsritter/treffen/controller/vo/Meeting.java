package com.alsritter.treffen.controller.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 传输给前端看的 Meeting
 *
 * @author alsritter
 * @version 1.0
 **/
@Data
public class Meeting implements Serializable {
    @ApiModelProperty("创建该会议的人")
    String userName;
    @ApiModelProperty("创建该会议的人的工号")
    String userEId;
    @ApiModelProperty("创建该会议的人的职位")
    private String job;
    @ApiModelProperty("创建该会议的人的手机号")
    private String phone;
    @ApiModelProperty("创建该会议的人的部门名称")
    private String deptName;
    @ApiModelProperty("创建该会议的人的部门位置")
    private String deptLocation;
    @ApiModelProperty("创建该会议的人的邮箱地址")
    private String email;

    @ApiModelProperty("开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh_CN", timezone = "GMT+8")
    private Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh_CN", timezone = "GMT+8")
    @ApiModelProperty("结束时间")
    private Date endTime;
    @ApiModelProperty("会议的类型")
    private String recordType;
    @ApiModelProperty("会议的内容")
    private String recordDesc;
    @ApiModelProperty("会议的 ID")
    private Integer meetingId;
}
