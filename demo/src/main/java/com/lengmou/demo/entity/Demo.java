package com.lengmou.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lengmou.demo.model.RedisEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author 冷眸
 */
@Data
@TableName("demo")
public class Demo extends RedisEntity implements Serializable {

    public static final String TABLE_NAME = "demo:";

    private String name;

    private Integer deleted;

    private Date created_at;

    private Date updated_at;

    public Demo(){
        super.setTableName(TABLE_NAME);
    }
}
