package com.alsritter.treffen.controller;

import com.google.code.kaptcha.Producer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

/**
 * @author alsritter
 * @version 1.0
 **/
@Api(tags = "登录验证")
@Slf4j
@RestController
public class ImageCodeController {
    @Autowired
    public void setCaptchaProducer(Producer captchaProducer) {
        this.captchaProducer = captchaProducer;
    }
    private Producer captchaProducer;

    @Resource
    StringRedisTemplate stringTemplate;

    @ApiOperation(value = "生成验证码图片")
    @GetMapping("/imagecode")
    public void getImageCode(HttpServletRequest request, HttpServletResponse response, String uuid) {
        //禁止缓存
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");

        //设置响应格式为png图片
        response.setContentType("image/png");

        //为验证码创建一个文本
        String codeText = captchaProducer.createText();
        //将验证码存到redis
        stringTemplate.opsForValue().set(ConstantKit.IMAGE_CODE + uuid, codeText);
        //设置验证码 5 分钟后到期
        stringTemplate.expire(ConstantKit.IMAGE_CODE + uuid, ConstantKit.IMAGE_CODE_EXPIRE_TIME, TimeUnit.SECONDS);

        try (ServletOutputStream out = response.getOutputStream()) {
            // 用创建的验证码文本生成图片
            BufferedImage bi = captchaProducer.createImage(codeText);
            //写出图片
            ImageIO.write(bi, "png", out);
            out.flush();
        } catch (Exception e) {
            log.warn(e.getMessage());
            throw new BizException(CommonEnum.INTERNAL_SERVER_ERROR.getResultCode(), "验证码生成错误");
        }
    }
}
