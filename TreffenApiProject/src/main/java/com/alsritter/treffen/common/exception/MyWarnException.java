package com.alsritter.treffen.common.exception;

import com.alsritter.treffen.common.ServiceErrorResultEnum;

/**
 * 警告类型
 *
 * @author alsritter
 * @version 1.0
 **/
public class MyWarnException extends MyBasicExceptionAbstract{
    public MyWarnException(ServiceErrorResultEnum serviceErrorResultEnum) {
        super(serviceErrorResultEnum);
    }

    public MyWarnException(ServiceErrorResultEnum serviceErrorResultEnum, Throwable cause) {
        super(serviceErrorResultEnum, cause);
    }

    public MyWarnException(Integer errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public MyWarnException(Integer errorCode, String errorMsg, Throwable cause) {
        super(errorCode, errorMsg, cause);
    }
}
