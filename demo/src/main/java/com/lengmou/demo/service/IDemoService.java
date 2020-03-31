package com.lengmou.demo.service;

import com.lengmou.demo.entity.Demo;
import com.lengmou.demo.mapper.DemoMapper;

/**
 * 测试
 * @Author 冷眸
 */
public interface IDemoService extends ITemplateService<Demo, DemoMapper> {
    String insertRedis(Demo demo);
}
