package com.alsritter.treffen.service.impl;

import com.alsritter.treffen.common.util.CurrentUserUtils;
import com.alsritter.treffen.common.util.JwtTokenUtils;
import com.alsritter.treffen.entity.TbRoles;
import com.alsritter.treffen.entity.TbUser;
import com.alsritter.treffen.service.AuthService;
import com.alsritter.treffen.service.UserRoleService;
import com.alsritter.treffen.service.UserService;
import com.alsritter.treffen.service.dto.JwtUser;
import com.alsritter.treffen.service.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author alsritter
 * @version 1.0
 **/
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final UserRoleService userRoleService;
    private final StringRedisTemplate stringRedisTemplate;
    private final CurrentUserUtils currentUserUtils;

    @Override
    public String getToken(LoginRequest loginRequest) {
        TbUser user = userService.find(loginRequest.getUsername());
        if (!userService.check(loginRequest.getPassword(), user.getUserPassword())) {
            throw new BadCredentialsException("The user name or password is not correct.");
        }
        // 取得该用户的权限
        List<TbRoles> permissionList = userRoleService.getPermissionList(user.getUserId());

        JwtUser jwtUser = new JwtUser(user, loginRequest.getRememberMe(), permissionList);

        // 获取权限列表
        List<String> authorities = jwtUser.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());


        String token = JwtTokenUtils.createToken(user.getUserName(), user.getUserId().toString(), authorities, loginRequest.getRememberMe());
        // 存到 redis 里面先
        stringRedisTemplate.opsForValue().set(user.getUserId().toString(), token);
        return token;
    }

    @Override
    public void deleteTokenFromRedis() {

    }
}
