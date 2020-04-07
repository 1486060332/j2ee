package com.lengmou.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Author 冷眸
 */
@Data
@TableName("demo")
public class Demo {

    public static final String TABLE_NAME = "demo:";

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String deleted;

    private Date createdAt;

    private Date updatedAt;

}
