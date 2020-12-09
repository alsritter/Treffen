package com.alsritter.treffen.service.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author alsritter
 * @version 1.0
 **/
public class UpdateMeetingRequest {
    @ApiModelProperty(value = "会议描述")
    private String recordDesc;
}
