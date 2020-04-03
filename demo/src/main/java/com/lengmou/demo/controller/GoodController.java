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
    @PostMapping("/reduceStock")
    public Result reduceStock(@RequestBody GoodVo goodVo){
        if(goodService.reduceStock(goodVo) == 1){
            return Result.success();
        }
        return Result.error("库存不足");
    }
}
