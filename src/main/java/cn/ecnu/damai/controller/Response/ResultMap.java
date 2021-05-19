package cn.ecnu.damai.controller.Response;

import com.alibaba.fastjson.JSON;
import lombok.Data;

@Data
public class ResultMap {
    private boolean success;
    private String message;
    private Integer code;
    private Object data;

    public ResultMap(ResultType resultType) {
        this.success = resultType.success;
        this.code = resultType.code;
        this.message = resultType.message;
    }

    public ResultMap(ResultType resultType, Object data) {
        this.success = resultType.success;
        this.code = resultType.code;
        this.message = resultType.message;
        this.data = data;
    }

    public ResultMap(ResultType resultType, String message) {
        this.success = resultType.success;
        this.code = resultType.code;
        this.message = message;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
