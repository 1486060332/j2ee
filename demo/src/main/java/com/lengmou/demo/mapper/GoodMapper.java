package com.lengmou.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lengmou.demo.entity.Good;
import com.lengmou.demo.entity.GoodVo;

/**
 * 商品mapper
 * @Author 冷眸
 */
public interface GoodMapper extends BaseMapper<Good> {
    /**
     * 减少库存
     * @param goodVo
     * @return int
     */
    int reduceStock(GoodVo goodVo);

    /**
     * 用悲观锁
     * @param id
     * @return
     */
    Good selectByIdForUpdate(Integer id);
}
