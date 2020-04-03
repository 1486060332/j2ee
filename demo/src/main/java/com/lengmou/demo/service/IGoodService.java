package com.lengmou.demo.service;

import com.lengmou.demo.entity.Good;
import com.lengmou.demo.entity.GoodVo;
import com.lengmou.demo.mapper.GoodMapper;

/**
 * good service interface
 * @Author 冷眸
 */
public interface IGoodService{
    /**
     * 减少库存
     * @param goodVo
     * @return
     */
    int reduceStock(GoodVo goodVo);

    /**
     * 插入商品
     * @param good
     */
    void insert(Good good);
}
