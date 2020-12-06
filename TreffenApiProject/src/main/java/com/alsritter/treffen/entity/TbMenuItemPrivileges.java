package com.alsritter.treffen.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * tb_dept
 * @author alsritter
 */
@Data
public class TbMenuItemPrivileges implements Serializable {
    /**
     * 部门编号
     */
    private Integer deptId;

    /**
     * 部门名称（索引）
     */
    private String deptName;

    /**
     * 部门描述
     */
    private String deptDesc;

    /**
     * 部门位置
     */
    private String deptLocation;

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
        TbMenuItemPrivileges other = (TbMenuItemPrivileges) that;
        return (this.getDeptId() == null ? other.getDeptId() == null : this.getDeptId().equals(other.getDeptId()))
            && (this.getDeptName() == null ? other.getDeptName() == null : this.getDeptName().equals(other.getDeptName()))
            && (this.getDeptDesc() == null ? other.getDeptDesc() == null : this.getDeptDesc().equals(other.getDeptDesc()))
            && (this.getDeptLocation() == null ? other.getDeptLocation() == null : this.getDeptLocation().equals(other.getDeptLocation()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDeptId() == null) ? 0 : getDeptId().hashCode());
        result = prime * result + ((getDeptName() == null) ? 0 : getDeptName().hashCode());
        result = prime * result + ((getDeptDesc() == null) ? 0 : getDeptDesc().hashCode());
        result = prime * result + ((getDeptLocation() == null) ? 0 : getDeptLocation().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", deptId=").append(deptId);
        sb.append(", deptName=").append(deptName);
        sb.append(", deptDesc=").append(deptDesc);
        sb.append(", deptLocation=").append(deptLocation);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}