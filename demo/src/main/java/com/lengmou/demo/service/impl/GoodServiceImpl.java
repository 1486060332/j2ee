package com.lengmou.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lengmou.demo.entity.Demo;
import com.lengmou.demo.entity.Good;
import com.lengmou.demo.entity.GoodVo;
import com.lengmou.demo.mapper.DemoMapper;
import com.lengmou.demo.mapper.GoodMapper;
import com.lengmou.demo.model.Result;
import com.lengmou.demo.service.IDemoService;
import com.lengmou.demo.service.IGoodService;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.concurrent.TimeUnit;

/**
 * @Author 冷眸
 */
@Service
public class GoodServiceImpl implements IGoodService {

    @Autowired(required = false)
    private GoodMapper goodMapper;
    @Autowired
    private IDemoService demoService;

    @Autowired
    private Redisson redisson;

    @Override
    public void insert(Good good) {
        goodMapper.insert(good);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result optimisticLocking(GoodVo goodVo) {
        Integer id = goodVo.getId();
        Good good = goodMapper.selectById(id);
        Demo demo = new Demo();
        if(good.getStock() >= goodVo.getReduceNumber()){
            Good updateGood = new Good();
            updateGood.setStock(good.getStock() - goodVo.getReduceNumber());
            QueryWrapper<Good> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", id);
            queryWrapper.eq("stock", good.getStock());
            int update = goodMapper.update(updateGood, queryWrapper);
            if(update == 1){
                demo.setName(Thread.currentThread().getName() + "-----SUCCESS-----" + goodVo.getReduceNumber());
                demoService.insertAsync(demo);
                return Result.success();
            }else {
                demo.setName(Thread.currentThread().getName() + "-----您所购商品数量发生变化，请重新下单！-----" + goodVo.getReduceNumber());
                demoService.insertAsync(demo);
                return Result.error("您所购商品数量发生变化，请重新下单！");
            }
        }
        demo.setName(Thread.currentThread().getName() + "-----您所购的商品库存不足，非常感谢您的支持！-----" + goodVo.getReduceNumber());
        demoService.insertAsync(demo);
        return Result.error("您所购的商品库存不足，非常感谢您的支持！");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public synchronized Result threadLocking(GoodVo goodVo) {
        Integer id = goodVo.getId();
        Good good = goodMapper.selectById(id);
        Demo demo = new Demo();
        if(good.getStock() >= goodVo.getReduceNumber()){
            Good updateGood = new Good();
            updateGood.setId(goodVo.getId());
            updateGood.setStock(good.getStock() - goodVo.getReduceNumber());
            int update = goodMapper.updateById(updateGood);
            if(update == 1){
                demo.setName(Thread.currentThread().getName() + "-----SUCCESS-----" + goodVo.getReduceNumber());
                demoService.insertAsync(demo);
                return Result.success();
            }
        }
        demo.setName(Thread.currentThread().getName() + "-----您所购的商品库存不足，非常感谢您的支持！-----" + goodVo.getReduceNumber());
        demoService.insertAsync(demo);
        return Result.error("您所购的商品库存不足，非常感谢您的支持！");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result pessimisticLocking(GoodVo goodVo) {
        Integer id = goodVo.getId();
        Good good = goodMapper.selectByIdForUpdate(id);
        Demo demo = new Demo();
        if(good.getStock() >= goodVo.getReduceNumber()){
            Good updateGood = new Good();
            updateGood.setId(goodVo.getId());
            updateGood.setStock(good.getStock() - goodVo.getReduceNumber());
            int update = goodMapper.updateById(updateGood);
            if(update == 1){
                demo.setName(Thread.currentThread().getName() +"------" + good.getId()  + "-----SUCCESS-----" + goodVo.getReduceNumber());
                demoService.insertAsync(demo);
                return Result.success();
            }
        }
        demo.setName(Thread.currentThread().getName() +"------" + good.getId() + "-----您所购的商品库存不足，非常感谢您的支持！-----" + goodVo.getReduceNumber());
        demoService.insertAsync(demo);
        return Result.error("您所购的商品库存不足，非常感谢您的支持！");
    }

    @Override
    public Result redissonLocking(GoodVo goodVo) {
        Integer id = goodVo.getId();
        StringBuffer lockKeyBuffer = new StringBuffer();
        lockKeyBuffer.append(Good.TABLE_NAME).append("lock:").append(id);
        RLock lock = redisson.getLock(lockKeyBuffer.toString());
        lock.lock(10, TimeUnit.SECONDS);
        Good good = goodMapper.selectById(id);
        try {
            Demo demo = new Demo();
            if(good.getStock() >= goodVo.getReduceNumber()){
                Good updateGood = new Good();
                updateGood.setId(goodVo.getId());
                updateGood.setStock(good.getStock() - goodVo.getReduceNumber());
                int update = goodMapper.updateById(updateGood);
                if(update == 1){
                    demo.setName(Thread.currentThread().getName() +"------" + good.getId() + "-----SUCCESS-----" + goodVo.getReduceNumber());
                    demoService.insertAsync(demo);
                    return Result.success();
                }
            }
            demo.setName(Thread.currentThread().getName() +"------" + good.getId() + "-----您所购的商品库存不足，非常感谢您的支持！-----" + goodVo.getReduceNumber());            demoService.insertAsync(demo);
            return Result.error("您所购的商品库存不足，非常感谢您的支持！");
        } catch (Exception e) {
            System.err.println(555);
            e.printStackTrace();
        } finally {
            lock.unlock();
            return Result.error("您所购的商品库存不足，非常感谢您的支持！");
        }
    }

}
