package com.alsritter.treffen.common;

/**
 * Spring Security 常数项
 *
 * @author alsritter
 * @version 1.0
 **/
public final class SecurityConstants {

    /**
     * 设置验证码到期时间为 5 分钟
     */
    public static final Integer IMAGE_CODE_EXPIRE_TIME = 5 * 60;

    /**
     * 验证码的 Key，加上这个可方便和其它 key 产生冲突
     */
    public static final String IMAGE_CODE = "IMAGE_CODE";


    /**
     * 角色的 key
     **/
    public static final String ROLE_CLAIMS = "rol";

    /**
     * rememberMe 为 false 的时候过期时间是1个小时
     */
    public static final long EXPIRATION = 60 * 60L;

    /**
     * rememberMe 为 true 的时候过期时间是7天
     */
    public static final long EXPIRATION_REMEMBER = 60 * 60 * 24 * 7L;

    /**
     * JWT签名密钥
     */
    public static final String JWT_SECRET_KEY = "pAjFyJV0w5BsxhjLcbeHPvif--pObLfqiEnQl1dhiQrNKRojMWA-5pGlndPwSo";

    // JWT token defaults
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_TYPE = "JWT";

    // Swagger WHITELIST
    public static final String[] SWAGGER_WHITELIST = {
            "/swagger-ui.html",
            "/swagger-ui/*",
            "/swagger-resources/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/webjars/**"
    };

    /**
     * 登录接口 WHITELIST 注意: 就算设置了 context-path 也不用加上 api
     */
    public static final String AUTH_LOGIN_URL = "/auth/login";

    /**
     * 白名单，里面的请求直接放行
     */
    public static final String[] GLOBAL_WHITE_LIST = {
      "/utils/imagecode"
    };

    // 过滤ALL
    public static final String FILTER_ALL = "/api/**";

    private SecurityConstants() {
    }

}
