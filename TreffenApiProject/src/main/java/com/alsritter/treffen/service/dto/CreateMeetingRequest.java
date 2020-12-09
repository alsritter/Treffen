package com.alsritter.treffen.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author alsritter
 * @version 1.0
 **/
@Data
public class CreateMeetingRequest {
    @NotEmpty(message = "会议类型不能为空")
    @ApiModelProperty(value = "会议类型不能为空", required = true)
    private String recordType;

    @ApiModelProperty(value = "会议描述")
    private String recordDesc;

    @NotEmpty()
    @ApiModelProperty(value = "会议开始时间", required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 会将时间转换为我们需要的格式
    private Date startTime;
}
