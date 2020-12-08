package com.alsritter.treffen.config.handler;

import com.alsritter.treffen.common.ServiceErrorResultEnum;
import com.alsritter.treffen.common.exception.MyErrorException;
import com.alsritter.treffen.common.exception.MyWarnException;
import com.alsritter.treffen.controller.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
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
     * @param e Spring 会捕获异常传入这个方法里
     */
    @ExceptionHandler(value = MyErrorException.class)
    public ResponseEntity<Result<String>> bizExceptionHandler(HttpServletResponse response, MyErrorException e) throws IOException {
        log.error("发生业务异常！原因是：{}", e.getErrorMsg());
        return ResponseEntity.status(e.getErrorCode()).body(
                Result.<String>builder()
                        .code(e.getErrorCode())
                        .message(e.getErrorMsg())
                        .build()
        );
    }

    /**
     * 处理自定义的业务异常
     *
     * @param e Spring 会捕获异常传入这个方法里
     */
    @ExceptionHandler(value = MyWarnException.class)
    public ResponseEntity<Result<String>> bizExceptionHandler(HttpServletResponse response, MyWarnException e) throws IOException {
        log.warn("发生业务异常！原因是：{}", e.getErrorMsg());
        return ResponseEntity.status(e.getErrorCode()).body(
                Result.<String>builder()
                        .code(e.getErrorCode())
                        .message(e.getErrorMsg())
                        .build()
        );
    }

    /**
     * 处理空指针的异常
     *
     * @param e Spring 会捕获 BizException 异常传入这个方法里
     */
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<Result<String>> exceptionHandler(HttpServletResponse response, NullPointerException e) throws IOException {
        log.error("发生空指针异常！原因是: ", e);
        return ResponseEntity.status(ServiceErrorResultEnum.INTERNAL_SERVER_ERROR.getResultCode()).body(
                Result.<String>builder()
                        .code(ServiceErrorResultEnum.INTERNAL_SERVER_ERROR.getResultCode())
                        .message(ServiceErrorResultEnum.INTERNAL_SERVER_ERROR.getResultMsg())
                        .build()
        );
    }

    /**
     * api 请求类型不符异常
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Result<String>> exceptionHandler(HttpServletResponse response, HttpRequestMethodNotSupportedException e) throws IOException {
        log.warn("api 请求类型不符合 当前请求的方法是: {}", e.getMethod());
        return ResponseEntity.status(ServiceErrorResultEnum.REQUEST_METHOD_NOT_EXIST.getResultCode()).body(
                Result.<String>builder()
                        .code(ServiceErrorResultEnum.REQUEST_METHOD_NOT_EXIST.getResultCode())
                        .message(ServiceErrorResultEnum.REQUEST_METHOD_NOT_EXIST.getResultMsg())
                        .build()
        );
    }

    /**
     * 参数读取异常
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<Result<String>> exceptionHandler(HttpServletResponse response, HttpMessageNotReadableException e) throws IOException {
        log.warn("参数读取异常 HTTP 请求的是: {}", e.getHttpInputMessage());
        return ResponseEntity.status(ServiceErrorResultEnum.PARAMETER_NOT_READABLE.getResultCode()).body(
                Result.<String>builder()
                        .code(ServiceErrorResultEnum.PARAMETER_NOT_READABLE.getResultCode())
                        .message(ServiceErrorResultEnum.PARAMETER_NOT_READABLE.getResultMsg())
                        .build()
        );
    }// MissingServletRequestParameterException

    /**
     * 丢失参数异常
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity<Result<String>> exceptionHandler(HttpServletResponse response, MissingServletRequestParameterException e) throws IOException {
        log.warn("丢失参数: {}", e.getParameterName());
        return ResponseEntity.status(ServiceErrorResultEnum.MISSING_PARAMETER_ERROR.getResultCode()).body(
                Result.<String>builder()
                        .code(ServiceErrorResultEnum.MISSING_PARAMETER_ERROR.getResultCode())
                        .message(ServiceErrorResultEnum.MISSING_PARAMETER_ERROR.getResultMsg())
                        .build()
        );
    }// MissingServletRequestParameterException

    /**
     * 请求参数绑定到 java bean 上失败时抛出
     */
    @ExceptionHandler(value = BindException.class)
    public ResponseEntity<Result<String>> exceptionHandler(HttpServletResponse response, BindException e) throws IOException {
        log.error("参数绑定到 Bean 上异常，来源于：{}  要绑定的属性名是：{}", e.getOrigin(), e.getProperty());
        return ResponseEntity.status(ServiceErrorResultEnum.PARAMETER_NOT_READABLE.getResultCode()).body(
                Result.<String>builder()
                        .code(ServiceErrorResultEnum.PARAMETER_NOT_READABLE.getResultCode())
                        .message(ServiceErrorResultEnum.PARAMETER_NOT_READABLE.getResultMsg())
                        .build()
        );
    }

    /**
     * 参数转换错误，因为 Spring 会自动把前端的请求参数转成对应的数据返回到形参上，所以当前端传入错误的参数过来转换不了就会报这个错
     */
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Result<String>> exceptionHandler(HttpServletResponse response, MethodArgumentTypeMismatchException e) throws IOException {
        log.error("参数转换错误，可能是传入的参数名和 value 位置写反了 访问的方法是：{}  参数名称为：{}", e.getParameter(), e.getName());
        return ResponseEntity.status(ServiceErrorResultEnum.PARAMETER_NOT_READABLE.getResultCode()).body(
                Result.<String>builder()
                        .code(ServiceErrorResultEnum.PARAMETER_NOT_READABLE.getResultCode())
                        .message(ServiceErrorResultEnum.PARAMETER_NOT_READABLE.getResultMsg())
                        .build()
        );
    }

    /**
     * 处理其他异常
     *
     * @param e Spring 会捕获 BizException 异常传入这个方法里
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Result<String>> exceptionHandler(HttpServletResponse response, Exception e) throws Exception {
        if (e instanceof AccessDeniedException
                || e instanceof AuthenticationException) {
            throw e;
        }
        log.error("未知异常！原因是:", e);
        return ResponseEntity.status(ServiceErrorResultEnum.INTERNAL_SERVER_ERROR.getResultCode()).body(
                Result.<String>builder()
                        .code(ServiceErrorResultEnum.INTERNAL_SERVER_ERROR.getResultCode())
                        .message(ServiceErrorResultEnum.INTERNAL_SERVER_ERROR.getResultMsg())
                        .build()
        );
    }
}
