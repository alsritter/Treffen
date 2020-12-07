package com.alsritter.treffen.common.exception;

import com.alsritter.treffen.common.ServiceErrorResultEnum;

/**
 * 自定义一个基本异常类，用于处理发生的业务异常
 * 因为可能有不同级别的报错，所以把异常类抽象处理对应创建就行了
 * 把这个类定为抽象类也是为了防止实例化
 */
public abstract class MyBasicExceptionAbstract extends RuntimeException  {
    /**
     * 错误码
     */
    protected final Integer errorCode;
    /**
     * 错误信息
     */
    protected final String errorMsg;


    public MyBasicExceptionAbstract(ServiceErrorResultEnum serviceErrorResultEnum) {
        super(serviceErrorResultEnum.getResultMsg());
        this.errorCode = serviceErrorResultEnum.getResultCode();
        this.errorMsg = serviceErrorResultEnum.getResultMsg();
    }

    public MyBasicExceptionAbstract(ServiceErrorResultEnum serviceErrorResultEnum, Throwable cause) {
        super(serviceErrorResultEnum.getResultMsg(), cause);
        this.errorCode = serviceErrorResultEnum.getResultCode();
        this.errorMsg = serviceErrorResultEnum.getResultMsg();
    }

    public MyBasicExceptionAbstract(Integer errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public MyBasicExceptionAbstract(Integer errorCode, String errorMsg, Throwable cause) {
        super(errorMsg, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "{" +
                "\"errorCode\":" + "\"" + errorCode + "\"" +
                ", \"errorMsg\":" + "\"" + errorMsg + "\"" +
                '}';
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    @Override
    public String getMessage() {
        return errorMsg;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
