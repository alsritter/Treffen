package com.alsritter.treffen.common;

/**
 * @author alsritter
 * @version 1.0
 **/
/**
 * 自定义一个异常类，用于处理发生的业务异常
 *
 * @author alsritter
 * @version 1.0
 **/
public class BizException extends RuntimeException {

    /**
     * 错误码
     */
    protected final Integer errorCode;
    /**
     * 错误信息
     */
    protected final String errorMsg;


    public BizException(ServiceErrorResultEnum serviceErrorResultEnum) {
        super(serviceErrorResultEnum.getResultMsg());
        this.errorCode = serviceErrorResultEnum.getResultCode();
        this.errorMsg = serviceErrorResultEnum.getResultMsg();
    }

    public BizException(ServiceErrorResultEnum serviceErrorResultEnum, Throwable cause) {
        super(serviceErrorResultEnum.getResultMsg(), cause);
        this.errorCode = serviceErrorResultEnum.getResultCode();
        this.errorMsg = serviceErrorResultEnum.getResultMsg();
    }

    public BizException(Integer errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BizException(Integer errorCode, String errorMsg, Throwable cause) {
        super(errorMsg, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
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
