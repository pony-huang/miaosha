package com.ponking.miaosha.exception;

import com.ponking.miaosha.result.Result;
import com.ponking.miaosha.result.ResultStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Ponking
 * @ClassName GlobalExceptionHandler
 * @date 2020/3/29--16:11
 * @Des 全局异常捕获器
 **/
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result<String> customException(HttpServletRequest request, Exception e){
        e.printStackTrace();
        if(e instanceof GlobalException) {
            GlobalException ex = (GlobalException)e;
            return Result.failed(ex.getMessage());
        }else if(e instanceof BindException) {
            BindException ex = (BindException)e;
            List<ObjectError> errors = ex.getAllErrors();
            ObjectError error = errors.get(0);
            String msg = error.getDefaultMessage();
            return Result.failed(ResultStatus.BIND_ERROR.getCode(),String.format(ResultStatus.BIND_ERROR.getMessage(),msg));
        }else {
            return Result.failed(ResultStatus.SERVER_ERROR.getMessage());
        }
    }
}
