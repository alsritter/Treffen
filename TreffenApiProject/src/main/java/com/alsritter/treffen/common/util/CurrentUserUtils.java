package com.alsritter.treffen.common.util;

import com.alsritter.treffen.entity.TbUser;
import com.alsritter.treffen.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

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

    private  String getCurrentUserName() {
        // 直接从线程的上下文中取得这个用户的信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() != null) {
            return (String) authentication.getPrincipal();
        }

        return null;
    }
}

