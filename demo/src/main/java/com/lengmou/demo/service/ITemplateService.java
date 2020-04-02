package com.lengmou.demo.service;


/**
 * CRUD模板，只连数据库
 * @Author 冷眸
 */
public interface ITemplateService<T, M> {
    /**
     * 插入数据
     * @param t
     * @return
     */
    int insert(T t);

    /**
     * 更新数据
     * @param t
     * @return
     */
    int updateById(T t);

    /**
     * 通过id查询数据
     * @param t
     * @return
     */
    T selectById(T t);

    /**
     * 删除数据
     * @param t
     * @return
     */
    int deleteById(T t);
}
