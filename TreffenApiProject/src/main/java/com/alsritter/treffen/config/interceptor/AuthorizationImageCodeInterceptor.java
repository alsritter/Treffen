package com.alsritter.treffen.config.interceptor;

import com.alsritter.treffen.common.BizException;
import com.alsritter.treffen.common.ConstantKit;
import com.alsritter.treffen.common.ServiceErrorResultEnum;
import com.alsritter.treffen.config.annotation.AuthImageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 用来检查验证码的拦截器
 *
 * @author alsritter
 * @version 1.0
 **/
public class AuthorizationImageCodeInterceptor implements HandlerInterceptor {
    @Autowired
    StringRedisTemplate stringTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 这个 HandlerMethod 可以用来匹配 Controller，如果不是 Controller 则跳过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        // 如果打上了 AuthImageCode 的注解先检查是否带了 validImageCode 和 uuid 参数
        // 如果带了就验证一下
        if (method.getAnnotation(AuthImageCode.class) != null ||
                handlerMethod.getBeanType().getAnnotation(AuthImageCode.class) != null) {

            String verifyCode = request.getParameter("verifyCode");
            String uuid = request.getParameter("uuid");

            // 参数为空
            if (verifyCode == null || uuid == null) {
                throw new BizException(ServiceErrorResultEnum.VERIFY_CODE_NULL);
            }

            // 参数为空
            if (verifyCode.equals("") || uuid.equals("")) {
                throw new BizException(ServiceErrorResultEnum.VERIFY_CODE_NULL);
            }

            // 先验证这个 uuid 是否存在
            if (stringTemplate.opsForValue().get(ConstantKit.IMAGE_CODE + uuid) == null) {
                throw new BizException(ServiceErrorResultEnum.VERIFY_CODE_TIMEOUT_OR_NOT_EXIST);
            }

            //先判断验证码是否正确
            if (!stringTemplate.opsForValue().get(ConstantKit.IMAGE_CODE + uuid).trim().equals(verifyCode)) {
                throw new BizException(ServiceErrorResultEnum.VERIFY_CODE_CREATE_ERROR);
            }
        }

        return true;
    }
}