package cn.ecnu.damai.controller.Response;

public enum ResultType {

    SUCCESS(true, 0, "操作成功"),
    FAIL(false, 200, "操作失败"),
    UNAUTHORITY(false, 300, "权限不足"),
    INVALID_PARAM(false, 301, "非法参数"),
    SEVER_ERROR(false, 999, "系统异常");

    public boolean success;
    public Integer code;
    public String message;

    private ResultType(boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

}
