package com.alsritter.treffen.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author alsritter
 * @version 1.0
 **/
@Data
public class UpdateMeetingRequest {
    @ApiModelProperty(value = "会议描述")
    @NotEmpty(message = "recordDesc 不能为空")
    private String recordDesc;
}
