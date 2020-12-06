package com.alsritter.treffen.service.impl;

import com.alsritter.treffen.entity.TbRoles;
import com.alsritter.treffen.mapper.UserRoleMapper;
import com.alsritter.treffen.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author alsritter
 * @version 1.0
 **/
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleMapper userRoleMapper;
    @Override
    public List<TbRoles> getPermissionList(Integer userId) {
        return userRoleMapper.selectByUserId(userId);
    }
}
