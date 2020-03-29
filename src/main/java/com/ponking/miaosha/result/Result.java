package com.ponking.miaosha.result;

import lombok.Data;

/**
 * @author Ponking
 * @ClassName Result
 * @date 2020/3/28--11:13
 **/
@Data
public class Result<T> {

    private Integer code;
    private String message;
    private T data;

    private Result(ResultStatus resultStatus, T data) {
        this.code = resultStatus.getCode();
        this.message = resultStatus.getMessage();
        this.data = data;
    }

    private Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private Result(String message, T data) {
        this.code = 0;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>(ResultStatus.SUCCESS, data);
    }

    public static <T> Result<T> failed(T data) {
        return new Result<T>(ResultStatus.FAILED, data);
    }

    public static <T> Result<T> failed(String message, T data) {
        return new Result<T>(message, data);
    }

    public static <T> Result<T> failed(Integer code, String message) {
        return new Result(code, message,null);
    }

    public static <T> Result<T> failed(Integer code, String message, T data) {
        return new Result<T>(code, message, data);
    }
}
