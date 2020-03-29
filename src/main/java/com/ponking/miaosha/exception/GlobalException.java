package com.ponking.miaosha.exception;

import com.ponking.miaosha.result.Result;
import com.ponking.miaosha.result.ResultStatus;

/**
 * @author Ponking
 * @ClassName GlobalException
 * @date 2020/3/29--15:41
 **/
public class GlobalException extends RuntimeException {

    public GlobalException(String message) {
        super(message);
    }

    public GlobalException(ResultStatus status) {
        super(status.getMessage());
    }
}
