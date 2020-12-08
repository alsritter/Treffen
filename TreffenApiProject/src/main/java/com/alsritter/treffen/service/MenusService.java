package com.alsritter.treffen.service;

import com.alsritter.treffen.controller.vo.Menu;
import com.alsritter.treffen.entity.TbMenuItem;

import java.util.List;

public interface MenusService {
    // TODO: 为这些菜单添加上权限
    List<Menu> getMenus();

    List<TbMenuItem> getMenuItemByRoleName(String roleName);
}
