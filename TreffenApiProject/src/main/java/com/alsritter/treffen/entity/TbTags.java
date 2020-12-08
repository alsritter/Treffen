package com.alsritter.treffen.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * tb_tags
 * @author 
 */
@Data
public class TbTags implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer tagId;

    /**
     * 创建时间
     */
    private Date tagCreateTime;

    private String tagDesc;

    @TableLogic
    private Byte isDeleted;

    private Integer userId;

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
        TbTags other = (TbTags) that;
        return (this.getTagId() == null ? other.getTagId() == null : this.getTagId().equals(other.getTagId()))
            && (this.getTagCreateTime() == null ? other.getTagCreateTime() == null : this.getTagCreateTime().equals(other.getTagCreateTime()))
            && (this.getTagDesc() == null ? other.getTagDesc() == null : this.getTagDesc().equals(other.getTagDesc()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTagId() == null) ? 0 : getTagId().hashCode());
        result = prime * result + ((getTagCreateTime() == null) ? 0 : getTagCreateTime().hashCode());
        result = prime * result + ((getTagDesc() == null) ? 0 : getTagDesc().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tagId=").append(tagId);
        sb.append(", tagCreateTime=").append(tagCreateTime);
        sb.append(", tagDesc=").append(tagDesc);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}