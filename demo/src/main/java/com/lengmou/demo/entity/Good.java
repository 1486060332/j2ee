package com.lengmou.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 商品信息
 * @Author 冷眸
 */
@Data
@TableName("good")
public class Good{
    public static final String TABLE_NAME = "good:";

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer price;

    private Integer stock;

    private Date createdAt;

    private Date updatedAt;

}
