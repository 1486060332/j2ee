package com.lengmou.demo.service;

import com.lengmou.demo.entity.Demo;
import com.lengmou.demo.mapper.DemoMapper;

/**
 * 测试
 * @Author 冷眸
 */
public interface IDemoService {
    /**
     * 插入数据
     * @param demo
     * @return
     */
    int insert(Demo demo);
    /**
     * 异步插入数据
     * @param demo
     * @return
     */
    void insertAsync(Demo demo);

    /**
     * 删除数据
     * @param demo
     * @return
     */
    int deleteById(Demo demo);

    /**
     * 修改数据
     * @param demo
     * @return
     */
    int updateById(Demo demo);

    /**
     * 查询数据
     * @param demo
     * @return
     */
    Demo selectById(Demo demo);
}
