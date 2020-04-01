package com.lengmou.demo.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public class TemplateServiceImpl<T, M extends BaseMapper<T>> implements ITemplateService<T, M> {
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
        return mapper.updateById(t);
    }

    @Override
    public T selectById(Integer id) {
        return mapper.selectById(id);
    }

    @Override
    public int deleteById(Integer id) {
        return mapper.deleteById(id);
    }
}
