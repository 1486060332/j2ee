package com.lengmou.demo.service.impl;

import com.lengmou.demo.entity.Demo;
import com.lengmou.demo.entity.Good;
import com.lengmou.demo.entity.GoodVo;
import com.lengmou.demo.mapper.DemoMapper;
import com.lengmou.demo.mapper.GoodMapper;
import com.lengmou.demo.service.IGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author 冷眸
 */
@Service
public class GoodServiceImpl implements IGoodService {

    @Autowired(required = false)
    private GoodMapper goodMapper;

    @Autowired(required = false)
    private DemoMapper demoMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int reduceStock(GoodVo goodVo) {
        Good good = goodMapper.selectByIdForUpdate(goodVo.getId());
        Integer stock = good.getStock();
        Integer reduceNumber = goodVo.getReduceNumber();
        if(stock > reduceNumber){
            int i = goodMapper.reduceStock(goodVo);
            Demo demo = new Demo();
            demo.setName("good" + goodVo.getReduceNumber());
            demoMapper.insert(demo);
            return i;
        }
        return 0;
    }

    @Override
    public void insert(Good good) {
        goodMapper.insert(good);
    }
}
