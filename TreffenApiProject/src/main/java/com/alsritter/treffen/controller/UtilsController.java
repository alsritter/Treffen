package com.alsritter.treffen.controller;

import com.alsritter.treffen.common.SecurityConstants;
import com.alsritter.treffen.common.exception.MyErrorException;
import com.alsritter.treffen.common.ServiceErrorResultEnum;
import com.alsritter.treffen.common.util.ResultGeneratorUtils;
import com.alsritter.treffen.controller.vo.Menu;
import com.alsritter.treffen.controller.vo.Result;
import com.alsritter.treffen.service.MenusService;
import com.google.code.kaptcha.Producer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author alsritter
 * @version 1.0
 **/
@Api(tags = "常用的工具接口")
@Slf4j
@RestController
@RequestMapping("/utils")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UtilsController {

    private final Producer captchaProducer;
    private final MenusService menusService;

    private final StringRedisTemplate stringTemplate;

    @ApiResponse(description = "返回一张验证码图片，这个接口无需权限")
    @ApiOperation(value = "生成验证码图片", notes = "返回一张图片")
    @GetMapping("/imagecode")
    public void getImageCode(HttpServletResponse response, @RequestParam @ApiParam(value = "生成验证码的唯一标识符") String uuid) {
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
        stringTemplate.opsForValue().set(SecurityConstants.IMAGE_CODE + uuid, codeText);
        //设置验证码 5 分钟后到期
        stringTemplate.expire(SecurityConstants.IMAGE_CODE + uuid, SecurityConstants.IMAGE_CODE_EXPIRE_TIME, TimeUnit.SECONDS);

        try (ServletOutputStream out = response.getOutputStream()) {
            // 用创建的验证码文本生成图片
            BufferedImage bi = captchaProducer.createImage(codeText);
            //写出图片
            ImageIO.write(bi, "png", out);
            out.flush();
        } catch (Exception e) {
            log.warn(e.getMessage());
            throw new MyErrorException(ServiceErrorResultEnum.VERIFY_CODE_CREATE_ERROR);
        }
    }


    @ApiOperation("根据权限动态返回一个菜单")
    @GetMapping("/getMenu")
    public ResponseEntity<Result<List<Menu>>> getMenu() {
        return ResponseEntity
                .ok()
                .body(
                        ResultGeneratorUtils.genSuccessResult(menusService.getMenus())
                );
    }
}
