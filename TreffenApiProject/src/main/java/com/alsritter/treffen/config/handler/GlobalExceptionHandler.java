package com.alsritter.treffen.config.handler;

import com.alsritter.treffen.common.BizException;
import com.alsritter.treffen.common.ServiceErrorResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author alsritter
 * @version 1.0
 **/
@ControllerAdvice
@Slf4j
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 处理自定义的业务异常
     *
     * @param e Spring 会捕获 BizException 异常传入这个方法里
     */
    @ExceptionHandler(value = BizException.class)
    public void bizExceptionHandler(HttpServletResponse response, BizException e) throws IOException {
        log.error("发生业务异常！原因是：{}", e.getErrorMsg());
        response.sendError(e.getErrorCode(), e.getMessage());
    }

    /**
     * 处理空指针的异常
     *
     * @param e Spring 会捕获 BizException 异常传入这个方法里
     */
    @ExceptionHandler(value = NullPointerException.class)
    public void exceptionHandler(HttpServletResponse response, NullPointerException e) throws IOException {
        log.error("发生空指针异常！原因是: ", e);
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
    }

    /**
     * api 请求类型不符异常
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public void exceptionHandler(HttpServletResponse response, HttpRequestMethodNotSupportedException e) throws IOException {
        log.error("api 请求类型不符合 当前请求的方法是: {}", e.getMethod());

        response.sendError(
                ServiceErrorResultEnum.REQUEST_METHOD_NOT_EXIST.getResultCode(),
                ServiceErrorResultEnum.REQUEST_METHOD_NOT_EXIST.getResultMsg());
    }

    /**
     * 参数读取异常
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public void exceptionHandler(HttpServletResponse response, HttpMessageNotReadableException e) throws IOException {
        log.error("参数读取异常 HTTP 请求的是: {}", e.getHttpInputMessage());
        response.sendError(
                ServiceErrorResultEnum.PARAMETER_NOT_READABLE.getResultCode(),
                ServiceErrorResultEnum.PARAMETER_NOT_READABLE.getResultMsg());
    }

    /**
     * 请求参数绑定到 java bean 上失败时抛出
     */
    @ExceptionHandler(value = BindException.class)
    public void exceptionHandler(HttpServletResponse response, BindException e) throws IOException {
        log.error("参数绑定到 Bean 上异常，来源于：{}  要绑定的属性名是：{}", e.getOrigin(), e.getProperty());
        response.sendError(
                ServiceErrorResultEnum.PARAMETER_NOT_READABLE.getResultCode(),
                ServiceErrorResultEnum.PARAMETER_NOT_READABLE.getResultMsg());
    }

    /**
     * 参数转换错误，因为 Spring 会自动把前端的请求参数转成对应的数据返回到形参上，所以当前端传入错误的参数过来转换不了就会报这个错
     */
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public void exceptionHandler(HttpServletResponse response, MethodArgumentTypeMismatchException e) throws IOException {
        log.error("参数转换错误，可能是传入的参数名和 value 位置写反了 访问的方法是：{}  参数名称为：{}", e.getParameter(), e.getName());
        response.sendError(
                ServiceErrorResultEnum.PARAMETER_NOT_READABLE.getResultCode(),
                ServiceErrorResultEnum.PARAMETER_NOT_READABLE.getResultMsg());
    }

    /**
     * 处理其他异常
     *
     * @param e Spring 会捕获 BizException 异常传入这个方法里
     */
    @ExceptionHandler(value = Exception.class)
    public void exceptionHandler(HttpServletResponse response, Exception e) throws IOException {
        log.error("未知异常！原因是:", e);
        response.sendError(
                ServiceErrorResultEnum.INTERNAL_SERVER_ERROR.getResultCode(),
                ServiceErrorResultEnum.INTERNAL_SERVER_ERROR.getResultMsg());
    }
}
