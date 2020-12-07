package com.alsritter.treffen.common.util;

import com.alsritter.treffen.common.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * JWT 工具类
 *
 * @author alsritter
 * @version 1.0
 **/
@Slf4j
public class JwtTokenUtils {



    /**
     * 生成足够的安全随机密钥，以适合符合规范的签名
     */
    private static final byte[] API_KEY_SECRET_BYTES = DatatypeConverter.parseBase64Binary(SecurityConstants.JWT_SECRET_KEY);
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(API_KEY_SECRET_BYTES);

    public static String createToken(String username, String id, List<String> roles, boolean isRememberMe) {
        // 是否选择 isRememberMe 的过期时长不一样
        long expiration = isRememberMe ? SecurityConstants.EXPIRATION_REMEMBER : SecurityConstants.EXPIRATION;

        final Date createdDate = new Date();
        final Date expirationDate = new Date(createdDate.getTime() + expiration * 1000);

        String tokenPrefix = Jwts.builder()
                .setHeaderParam("type", SecurityConstants.TOKEN_TYPE)
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .claim(SecurityConstants.ROLE_CLAIMS, String.join(",", roles))
                .setId(id)
                .setIssuer("alsritter")
                .setIssuedAt(createdDate)
                .setSubject(username)
                .setExpiration(expirationDate)
                .compact();

        return SecurityConstants.TOKEN_PREFIX + tokenPrefix; // 添加 token 前缀 "Bearer "; 这个是 OAuth 的协议
    }

    public static String getId(String token) {
        Claims claims = getClaims(token);
        return claims.getId();
    }

    /**
     * @param token 传入一个 JWT
     * @return 返回以一个
     */
    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
        // 先把 Token 解码成 Claims
        Claims claims = getClaims(token);
        List<SimpleGrantedAuthority> authorities = getAuthorities(claims);
        String userName = claims.getSubject();
        return new UsernamePasswordAuthenticationToken(userName, token, authorities);
    }

    private static List<SimpleGrantedAuthority> getAuthorities(Claims claims) {
        // 取得用户的权限
        String role = (String) claims.get(SecurityConstants.ROLE_CLAIMS);
        // GrantedAuthority 接口的默认实现 SimpleGrantedAuthority 中其实就只是比对字符串是否匹配
        return Arrays.stream(role.split(",")) // 这个是流操作
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    private static Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

}

