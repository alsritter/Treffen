package com.alsritter.treffen.common.util;

import com.alsritter.treffen.entity.TbUser;
import com.alsritter.treffen.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 获取当前用户
 *
 * @author alsritter
 * @version 1.0
 **/
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CurrentUserUtils {

    private final UserService userService;

    public TbUser getCurrentUser() {
        return userService.find(getCurrentUserName());
    }

    private String getCurrentUserName() {
        // 直接从线程的上下文中取得这个用户的信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() != null) {
            return (String) authentication.getPrincipal();
        }
        // 找不到则抛出一个要求登陆的异常，因为需要调用这个方法的地方基本都是要求登陆的且都能到这里表示还是携带了 Token 的，所以这里姑且认为用户是过期了
        throw new AccountExpiredException("找不到用户信息");
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() != null) {
            return authentication.getAuthorities();
        }
        // 没找到则返回一个空集
        throw new AccountExpiredException("找不到用户信息");
    }
}

