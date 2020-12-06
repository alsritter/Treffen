package com.alsritter.treffen.service;

import com.alsritter.treffen.entity.TbRoles;

import java.util.List;

public interface UserRoleService {
    List<TbRoles> getPermissionList(Integer userId);
}
