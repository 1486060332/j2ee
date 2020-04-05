package com.lengmou.demo.service;

import com.lengmou.demo.entity.Good;
import com.lengmou.demo.entity.GoodVo;
import com.lengmou.demo.mapper.GoodMapper;
import com.lengmou.demo.model.Result;

/**
 * good service interface
 * @Author 冷眸
 */
public interface IGoodService{


    /**
     * 插入商品
     * @param good
     */
    void insert(Good good);

    /**
     * 减少库存乐观锁
     * @param goodVo
     * @return
     */
    Result optimisticLocking(GoodVo goodVo);

    /**
     * 减少库存线程锁
     * @param goodVo
     * @return
     */
    Result threadLocking(GoodVo goodVo);

    /**
     * 减少库存悲观锁
     * @param goodVo
     * @return
     */
    Result pessimisticLocking(GoodVo goodVo);

    /**
     * 减少库存分布式锁
     * @param goodVo
     * @return
     */
    Result redissonLocking(GoodVo goodVo);
}
