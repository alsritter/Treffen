package com.alsritter.treffen.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * tb_tasks
 * @author 
 */
@Data
public class TbTasks implements Serializable {

    // TODO: 子任务树型结构（组织模式）

    @TableId(type = IdType.AUTO)
    private Integer taskId;

    /**
     * 任务描述
     */
    private String taskDesc;

    /**
     * 用来存储出席人物的 用户/部门，记录的是 用户/部门的数组，每个值使用;进行分隔
     */
    private String attendee;

    /**
     * 用来标识是否于部门有关：要考虑以下情况1. 接收人是一个用户2. 接收人是一个部门 3. 接收人是多个部门 4. 接收人是多个不同部门的人
     */
    private Integer isDept;

    private Date createTime;

    /**
     * 任务的进度，0 任务中 1 结束
     */
    private Integer isEnd;

    /**
     * 任务负责人
     */
    private Integer hostId;

    @TableLogic
    private Byte isDeleted;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TbTasks other = (TbTasks) that;
        return (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getTaskDesc() == null ? other.getTaskDesc() == null : this.getTaskDesc().equals(other.getTaskDesc()))
            && (this.getAttendee() == null ? other.getAttendee() == null : this.getAttendee().equals(other.getAttendee()))
            && (this.getIsDept() == null ? other.getIsDept() == null : this.getIsDept().equals(other.getIsDept()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getIsEnd() == null ? other.getIsEnd() == null : this.getIsEnd().equals(other.getIsEnd()))
            && (this.getHostId() == null ? other.getHostId() == null : this.getHostId().equals(other.getHostId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getTaskDesc() == null) ? 0 : getTaskDesc().hashCode());
        result = prime * result + ((getAttendee() == null) ? 0 : getAttendee().hashCode());
        result = prime * result + ((getIsDept() == null) ? 0 : getIsDept().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getIsEnd() == null) ? 0 : getIsEnd().hashCode());
        result = prime * result + ((getHostId() == null) ? 0 : getHostId().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", taskId=").append(taskId);
        sb.append(", taskDesc=").append(taskDesc);
        sb.append(", attendee=").append(attendee);
        sb.append(", isDept=").append(isDept);
        sb.append(", createTime=").append(createTime);
        sb.append(", isEnd=").append(isEnd);
        sb.append(", hostId=").append(hostId);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}