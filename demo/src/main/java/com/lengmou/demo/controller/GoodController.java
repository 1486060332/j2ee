package com.lengmou.demo.controller;

import com.lengmou.demo.entity.Good;
import com.lengmou.demo.entity.GoodVo;
import com.lengmou.demo.model.Result;
import com.lengmou.demo.service.IGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * good controller
 * @Author 冷眸
 */

@RestController
@RequestMapping("/good")
public class GoodController {
    @Autowired
    private IGoodService goodService;
    @PostMapping("/insert")
    public Result insert(@RequestBody Good good){
        goodService.insert(good);
        return Result.success();
    }

    /**
     * 创建订单“乐观锁”方式
     * @param goodVo
     * @return
     */
    @PostMapping("/optimisticLocking")
    public Result optimisticLocking(@RequestBody GoodVo goodVo){
        return goodService.optimisticLocking(goodVo);
    }

    /**
     * 创建订单“线程锁”方式
     * @param goodVo
     * @return
     */
    @PostMapping("/threadLocking")
    public Result threadLocking(@RequestBody GoodVo goodVo){
        return goodService.threadLocking(goodVo);
    }

    /**
     * 创建订单“悲观锁”方式
     * @param goodVo
     * @return
     */
    @PostMapping("/pessimisticLocking")
    public Result pessimisticLocking(@RequestBody GoodVo goodVo){
        return goodService.pessimisticLocking(goodVo);
    }

    /**
     * 创建订单分布式锁
     * @param goodVo
     * @return
     */
    @PostMapping("redissonLocking")
    public Result redissonLocking(@RequestBody GoodVo goodVo){
        return goodService.redissonLocking(goodVo);
    }
}
