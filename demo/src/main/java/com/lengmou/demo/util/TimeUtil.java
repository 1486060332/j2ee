package com.lengmou.demo.util;

/**
 * 时间工具类
 * @Author 冷眸
 */
public class TimeUtil {

    public static final Integer TIMESTAMP_TYPE_SECOND = 1;

    public static final Integer TIMESTAMP_TYPE_MILLIS = 2;

    public static Long timestamp(Integer type){
        long currentTimeMillis = System.currentTimeMillis();
        if(type == 1){
            return currentTimeMillis / 1000L;
        }
        return currentTimeMillis;
    }
}
