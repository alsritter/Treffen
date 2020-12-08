package com.alsritter.treffen.service.impl;

import com.alsritter.treffen.common.SecurityConstants;
import com.alsritter.treffen.common.util.CurrentUserUtils;
import com.alsritter.treffen.controller.vo.Menu;
import com.alsritter.treffen.entity.TbMenuItem;
import com.alsritter.treffen.entity.TbMenuItemGroup;
import com.alsritter.treffen.mapper.TbMenuItemGroupMapper;
import com.alsritter.treffen.mapper.TbMenuItemMapper;
import com.alsritter.treffen.service.MenusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author alsritter
 * @version 1.0
 **/
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MenusServiceImpl implements MenusService {
    private final CurrentUserUtils currentUserUtils;
    private final TbMenuItemGroupMapper menuItemGroupMapper;
    private final TbMenuItemMapper menuItemMapper;

    /**
     * 这里巨费啊，所以前端登陆后获取一次菜单之后要保存进 localStore 里面
     * 只有登出或者重新登陆之后再清除
     * @return 用户的菜单
     */
    @Override
    public List<Menu> getMenus() {
        // 先取得所以的分组，因为默认需要全部分组，所以这里直接就无需条件了
        List<TbMenuItemGroup> tbMenuItemGroups = menuItemGroupMapper.selectList(null);
        List<Menu> menus = new ArrayList<>();
        // 根据权限取得当前用户的 item
        Collection<? extends GrantedAuthority> authorities = currentUserUtils.getAuthorities();
        // 创建一个 Set 集合
        Set<TbMenuItem> tbMenuItemSet = new HashSet<>();

        for (GrantedAuthority authority : authorities) {
            List<TbMenuItem> menuItemByRoleName = getMenuItemByRoleName(authority.getAuthority());
            tbMenuItemSet.addAll(menuItemByRoleName);

            // 因为 ADMIN 默认有全部的权限，所以遇到 ADMIN 权限直接跳出
            if (SecurityConstants.ADMIN.equals(authority.getAuthority())) break;
        }


        log.debug("tbMenuItemSet: {}", tbMenuItemSet.toString());


        // TODO: 优化这里的代码
        // 再分组获取 Item
        tbMenuItemGroups.forEach(x -> {
            Menu menu = new Menu();
            List<TbMenuItem> menuItemList = new ArrayList<>();
            // 添加到当前分组中去
            for (TbMenuItem tbMenuItem : tbMenuItemSet) {
                if (x.getGroupId().equals(tbMenuItem.getItemGroup())) {
                    menuItemList.add(tbMenuItem);
                }
            }
            // 如果当前分组包含了元素则添加进集合里面，否则不添加
            if (!menuItemList.isEmpty()) {
                menu.setItemList(menuItemList);
                menu.setMenuItemGroup(x);
                menus.add(menu);
            }
        });

        log.debug("tbMenuItemGroups: {}", tbMenuItemGroups.toString());

        return menus;
    }

    @Override
    public List<TbMenuItem> getMenuItemByRoleName(String roleName) {
        return menuItemMapper.getMenuItemByRoleName(roleName);
    }
}
