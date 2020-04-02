package com.lengmou.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * redisTemplate 用于提取存入redis的key
 * @Author 冷眸
 */
@Data
public class RedisEntity {
    @TableField(exist = false)
    private String tableName;
    @TableId(type = IdType.AUTO)
    private Integer id;
    public String toKey(){
        StringBuffer buffer = new StringBuffer(tableName);
        buffer.append(id);
        return buffer.toString();
    }

}
