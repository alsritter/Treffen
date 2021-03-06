package com.alsritter.treffen.config;

import com.alsritter.treffen.common.SecurityConstants;
import com.alsritter.treffen.config.filter.JwtAuthorizationFilter;
import com.alsritter.treffen.config.handler.JwtAccessDeniedHandler;
import com.alsritter.treffen.config.handler.JwtAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static java.util.Collections.singletonList;
import static org.springframework.security.config.Customizer.withDefaults;

/**
 * 配置安全类
 *
 * @author alsritter
 * @version 1.0
 **/
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final StringRedisTemplate stringRedisTemplate;

    /**
     * 使用构造方法的形式自动注入 stringRedisTemplate
     *
     * @param stringRedisTemplate 把 JWT 存储到 Redis 里面
     */
    public SecurityConfiguration(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    /**
     * 密码编码器
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors(withDefaults())
                // 禁用 CSRF
                .csrf().disable()
                .authorizeRequests()
                // 放行 swagger 文档
                .antMatchers(SecurityConstants.SWAGGER_WHITELIST).permitAll()
                // 放行登录接口
                .antMatchers(HttpMethod.POST, SecurityConstants.AUTH_LOGIN_URL).permitAll()
                // 设置白名单
                .antMatchers(SecurityConstants.GLOBAL_WHITE_LIST).permitAll()
                // 指定路径下的资源需要验证了的用户才能访问（这里默认是 ALL）
                .antMatchers(SecurityConstants.FILTER_ALL).authenticated()
                // 所有的删除操作必须是管理员才行
                .antMatchers(HttpMethod.DELETE, SecurityConstants.FILTER_ALL).hasRole("ADMIN")
                // 其它请求直接放行（通过 Spring EL 的注解在 Controller 上面写需要的权限，而非全部拦截）
                .anyRequest().permitAll()
                .and()
                //添加自定义 Filter（这个只用来处理是否携带 Token，以及 Token 是否正确）
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), stringRedisTemplate))
                // 不需要session（不创建会话，即不采用默认的 Session-Cookie 登陆策略）
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // 异常处理
                .exceptionHandling()
                // AccessDeniedHandler 仅适用于经过身份验证的用户。未经身份验证的用户的默认行为是重定向到登录页面,
                // 如果要更改此设置，则需要配置一个 AuthenticationEntryPoint
                .authenticationEntryPoint(new JwtAuthenticationEntryPoint())
                // 因为使用的是自定义的登陆方式，所以需要自定义 403 处理
                .accessDeniedHandler(new JwtAccessDeniedHandler());
        // 防止 H2 web 页面的 Frame 被拦截
        http.headers().frameOptions().disable();
    }

    /**
     * Cors配置优化
     **/
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        org.springframework.web.cors.CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(singletonList("http://127.0.0.1:5500"));
        configuration.setAllowedHeaders(singletonList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT", "OPTIONS"));
        // 暴露这个 Authorization 属性，否则无法获取到 Token 信息
        configuration.setExposedHeaders(singletonList(SecurityConstants.TOKEN_HEADER));
        // 因为没有配置 HTTPS 所以就无需打开这个了
        configuration.setAllowCredentials(false);
        configuration.setMaxAge(3600l);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}