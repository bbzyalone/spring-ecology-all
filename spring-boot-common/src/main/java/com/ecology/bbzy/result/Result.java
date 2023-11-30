package com.ecology.bbzy.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.io.Serializable;

/**
 * @author wangkeqiang
 * @date 2020-06-23
 **/
@Data
public class Result<T> implements Serializable {

    /**
     * 返回码
     */
    private String code;

    /**
     * 数据对象
     */
    @JsonInclude(JsonInclude.Include.NON_NULL) //数据对象为空时去掉接口返回
    private T data;

    /**
     * 返回说明
     */
    private String msg;


    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> success(T data) {
        ResultCode rce = ResultCode.SUCCESS;
        if (data instanceof Boolean && Boolean.FALSE.equals(data)) {
            rce = ResultCode.SYSTEM_EXECUTION_ERROR;
        }
        return result(rce, data);
    }


    public static <T> Result<T> success(T data, Long total) {
        Result<T> result = new Result();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMsg());
        result.setData(data);
        return result;
    }

    public static <T> Result<T> failed() {
        return result(ResultCode.SYSTEM_EXECUTION_ERROR.getCode(), ResultCode.SYSTEM_EXECUTION_ERROR.getMsg(), null);
    }

    public static <T> Result<T> failed(String msg) {
        return result(ResultCode.SYSTEM_EXECUTION_ERROR.getCode(), msg, null);
    }

    public static <T> Result<T> judge(boolean status) {
        if (status) {
            return success();
        } else {
            return failed();
        }
    }

    public static <T> Result<T> failed(IResultCode resultCode) {
        return result(resultCode.getCode(), resultCode.getMsg(), null);
    }

    private static <T> Result<T> result(IResultCode resultCode, T data) {
        return result(resultCode.getCode(), resultCode.getMsg(), data);
    }

    private static <T> Result<T> result(String code, String msg, T data) {
        Result<T> result = new Result<T>();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }


    public static boolean isSuccess(Result result) {
        if (result != null && ResultCode.SUCCESS.getCode().equals(result.getCode())) {
            return true;
        }
        return false;
    }
}