package com.alsritter.treffen.common.util;

import com.alsritter.treffen.controller.vo.Result;

/**
 * 快速生成一个 Result 模板
 *
 * @author alsritter
 * @version 1.0
 **/
public final class ResultGeneratorUtils {

    private ResultGeneratorUtils(){}

    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private static final int RESULT_CODE_SUCCESS = 200;

    public static Result<String> genSuccessResult() {
        return Result.<String>builder()
                .code(RESULT_CODE_SUCCESS)
                .message(DEFAULT_SUCCESS_MESSAGE)
                .build();
    }

    public static Result<String> genSuccessResult(String message) {
        return Result.<String>builder()
                .code(RESULT_CODE_SUCCESS)
                .message(message)
                .build();
    }

    public static <T> Result<T> genSuccessResult(T data) {
        return Result.<T>builder()
                .code(RESULT_CODE_SUCCESS)
                .message(DEFAULT_SUCCESS_MESSAGE)
                .data(data)
                .build();
    }

    public static <T> Result<T> genSuccessResult(String message, T data) {
        return Result.<T>builder()
                .code(RESULT_CODE_SUCCESS)
                .message(message)
                .data(data)
                .build();
    }
}
