package com.alsritter.treffen.config.filter;

import com.alsritter.treffen.common.SecurityConstants;
import com.alsritter.treffen.common.util.JwtTokenUtils;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证 JWT 信息的过滤器，用于判断权限
 * 过滤器处理所有 HTTP 请求，并检查是否存在带有正确令牌的 Authorization 标头。
 * 例如，如果令牌未过期或签名密钥正确。
 *
 * SpringSecurity 提供两种登陆方式
 * `UsernamePasswordAuthenticationFilter` 表示表单登陆过滤器
 * `BasicAuthenticationFilter` 表示 httpBasic 方式登陆过滤器
 *
 * @author alsritter
 * @version 1.0
 **/
@Slf4j
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private final StringRedisTemplate stringRedisTemplate;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, StringRedisTemplate stringRedisTemplate) {
        super(authenticationManager);
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        String token = request.getHeader(SecurityConstants.TOKEN_HEADER);
        // token 为空，或者不规范（不以 Bearer 开头）的先清除上下文，使之直接跳转到登陆页
        if (token == null || !token.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            SecurityContextHolder.clearContext();
            chain.doFilter(request, response);
            return;
        }

        String tokenValue = token.replace(SecurityConstants.TOKEN_PREFIX, "");
        // 这个 UsernamePasswordAuthenticationToken 用来存储
        // 关键是能直接在这里通过 getPrincipal() 取得 UserDetails（虽然显示是 Object，但是实际是 UserDetails）
        //
        UsernamePasswordAuthenticationToken authentication = null;
        try {
            String previousToken = stringRedisTemplate.opsForValue().get(JwtTokenUtils.getId(tokenValue));
            // 和存储在 Redis 里的 Token 进行比对，看是否过期了
            if (!token.equals(previousToken)) {
                SecurityContextHolder.clearContext();
                chain.doFilter(request, response);
                return;
            }

            // 这里也封装了权限信息
            authentication = JwtTokenUtils.getAuthentication(tokenValue);
        } catch (JwtException e) {
            logger.error("Invalid jwt : " + e.getMessage());
        }

        // 全部认证通过就可以把这个存储了个人信息的 authentication 传递到 Context 中，以便后面调用
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }
}

