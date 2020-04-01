package com.lengmou.demo.service.impl;

import com.lengmou.demo.entity.Demo;
import com.lengmou.demo.mapper.DemoMapper;
import com.lengmou.demo.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * 测试
 * @Author 冷眸
 */
@Service
public class DemoServiceImpl extends TemplateServiceImpl<Demo, DemoMapper> implements IDemoService {

}
