package com.lengmou.demo.model;

import com.lengmou.demo.util.TimeUtil;
import lombok.Data;

/**
 * 统一返回类型
 * @Author
 */
@Data
public class Result {
    public static final Integer SUCCESS_RET = 200;

    public static final Integer ERROR_RET = 500;

    public static final String SUCCESS_MSG = "success";

    public static final String ERROR_MSG = "error";

    private int ret;
    private String msg;
    private Long timestamp;
    private Object data;

    private Result(){}

    private Result(int ret, String msg, Long timestamp){
        this.ret = ret;
        this.msg = msg;
        this.timestamp = timestamp;
    }

    public static Result success(){
        Result result = new Result(SUCCESS_RET, SUCCESS_MSG, TimeUtil.timestamp(TimeUtil.TIMESTAMP_TYPE_SECOND));
        return result;
    }

    public static Result success(Object object){
        Result success = success();
        success.setData(object);
        return success;
    }

    public static Result error(){
        Result result = new Result(ERROR_RET, ERROR_MSG, TimeUtil.timestamp(TimeUtil.TIMESTAMP_TYPE_SECOND));
        return result;
    }

    public static Result error(String msg){
        Result result = new Result(ERROR_RET, msg, TimeUtil.timestamp(TimeUtil.TIMESTAMP_TYPE_SECOND));
        return result;
    }
}
