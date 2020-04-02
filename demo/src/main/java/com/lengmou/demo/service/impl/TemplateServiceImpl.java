package com.lengmou.demo.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lengmou.demo.entity.RedisEntity;
import com.lengmou.demo.service.ITemplateService;
import com.lengmou.demo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author 冷眸
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TemplateServiceImpl<T extends RedisEntity, M extends BaseMapper<T>> implements ITemplateService<T, M> {
    @Autowired(required = false)
    private M mapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public int insert(T t) {
        return mapper.insert(t);
    }

    @Override
    public int updateById(T t) {
        System.out.println(t.toKey());
        redisUtil.del(t.toKey());
        return mapper.updateById(t);
    }

    @Override
    public T selectById(T t) {
        T o = (T) redisUtil.get(t.toKey());
        if(o != null){
            return o;
        }
        T t1 = mapper.selectById(t.getId());
        if(t1 != null){
            redisUtil.set(t1.toKey(), t1);
        }
        return t1;
    }

    @Override
    public int deleteById(T t) {
        redisUtil.del(t.toKey());
        return mapper.deleteById(t.getId());
    }
}
