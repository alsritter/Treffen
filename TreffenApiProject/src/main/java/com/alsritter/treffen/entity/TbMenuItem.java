package com.alsritter.treffen.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * tb_menu_item
 * @author 
 */
@Data
public class TbMenuItem implements Serializable {
    private Integer itemId;

    /**
     * 菜单每项的名称
     */
    private String itemName;

    @TableLogic
    private Byte isDeleted;

    /**
     * 菜单功能描述
     */
    private String itemDesc;

    private String itemPath;

    /**
     * 设置分组，标识当前这个 item 属于哪个分组下面的
     */
    private Integer itemGroup;

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
        TbMenuItem other = (TbMenuItem) that;
        return (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getItemName() == null ? other.getItemName() == null : this.getItemName().equals(other.getItemName()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getItemDesc() == null ? other.getItemDesc() == null : this.getItemDesc().equals(other.getItemDesc()))
            && (this.getItemPath() == null ? other.getItemPath() == null : this.getItemPath().equals(other.getItemPath()))
            && (this.getItemGroup() == null ? other.getItemGroup() == null : this.getItemGroup().equals(other.getItemGroup()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getItemName() == null) ? 0 : getItemName().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        result = prime * result + ((getItemDesc() == null) ? 0 : getItemDesc().hashCode());
        result = prime * result + ((getItemPath() == null) ? 0 : getItemPath().hashCode());
        result = prime * result + ((getItemGroup() == null) ? 0 : getItemGroup().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", itemId=").append(itemId);
        sb.append(", itemName=").append(itemName);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", itemDesc=").append(itemDesc);
        sb.append(", itemPath=").append(itemPath);
        sb.append(", itemGroup=").append(itemGroup);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}