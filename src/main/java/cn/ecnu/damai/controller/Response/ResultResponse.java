package cn.ecnu.damai.controller.Response;

import com.alibaba.fastjson.JSON;

public class ResultResponse {
    private boolean success;
    private String message;
    private Integer code;
    private Object data;

    private ResultResponse(boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public static ResultResponse SUCCESS() {
        return new ResultResponse(true, 0,"提交成功");
    }

    public static ResultResponse FAIL() {
        return new ResultResponse(false, 200, "操作失败");
    }

    public static ResultResponse SERVER_ERROR() {
        return new ResultResponse(false, 999, "系统异常");
    }

    public String toString() {
        return JSON.toJSONString(this);
    }

    public boolean isSuccess() {
        return success;
    }

    public ResultResponse setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResultResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public ResultResponse setCode(Integer code) {
        this.code = code;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResultResponse setData(Object data) {
        this.data = data;
        return this;
    }
}
