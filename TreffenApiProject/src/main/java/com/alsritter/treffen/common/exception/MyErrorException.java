package com.alsritter.treffen.common.exception;

/**
 * @author alsritter
 * @version 1.0
 **/

import com.alsritter.treffen.common.ServiceErrorResultEnum;

/**
 *
 *
 * @author alsritter
 * @version 1.0
 **/
public class MyErrorException extends MyBasicExceptionAbstract {

    public MyErrorException(ServiceErrorResultEnum serviceErrorResultEnum) {
        super(serviceErrorResultEnum);
    }

    public MyErrorException(ServiceErrorResultEnum serviceErrorResultEnum, Throwable cause) {
        super(serviceErrorResultEnum, cause);
    }

    public MyErrorException(Integer errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public MyErrorException(Integer errorCode, String errorMsg, Throwable cause) {
        super(errorCode, errorMsg, cause);
    }
}
