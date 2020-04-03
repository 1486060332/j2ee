package com.lengmou.demo.service.impl;

import com.lengmou.demo.entity.Demo;
import com.lengmou.demo.mapper.DemoMapper;
import com.lengmou.demo.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 测试
 * @Author 冷眸
 */
@Service
public class DemoServiceImpl implements IDemoService {

    @Autowired(required = false)
    private DemoMapper demoMapper;
    @Override
    public int insert(Demo demo) {
        return demoMapper.insert(demo);
    }

    @Override
    public int deleteById(Demo demo) {
        return demoMapper.deleteById(demo.getId());
    }

    @Override
    public int updateById(Demo demo) {
        return demoMapper.updateById(demo);
    }

    @Override
    public Demo selectById(Demo demo) {
        return demoMapper.selectById(demo.getId());
    }
}
