package com.lengmou.demo.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lengmou.demo.service.ITemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 冷眸
 */
@Service
public class TemplateServiceImpl<T, M extends BaseMapper<T>> implements ITemplateService<T, M> {
    @Autowired(required = false)
    private M mapper;

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
