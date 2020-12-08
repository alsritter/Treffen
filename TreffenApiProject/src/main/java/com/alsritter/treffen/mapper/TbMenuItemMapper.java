package com.alsritter.treffen.mapper;

import com.alsritter.treffen.entity.TbMenuItem;
import com.alsritter.treffen.entity.TbRoles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface TbMenuItemMapper extends BaseMapper<TbMenuItem> {
    List<TbMenuItem> getMenuItemByRoleId(Integer roleId);

    List<TbMenuItem> getMenuItemByRoleName(String roleName);
}