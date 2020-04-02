package com.lengmou.demo.controller;

import com.lengmou.demo.entity.Demo;
import com.lengmou.demo.model.Result;
import com.lengmou.demo.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 冷眸
 */
@RestController
@RequestMapping("demo")
public class DemoController {

    @Autowired
    private IDemoService demoService;

    @PostMapping("/insert")
    Result insert(@RequestBody Demo demo){
        if(demoService.insert(demo) == 1){
            return Result.success();
        }
        return Result.error();
    }
    @PostMapping("/deleteById")
    Result deleteById(@RequestBody Integer id){
        Demo demo = new Demo();
        demo.setId(id);
        if(demoService.deleteById(demo) == 1){
            return Result.success();
        }
        return Result.error();
    }
    @PostMapping("/updateById")
    Result updateById(@RequestBody Demo demo){
        if(demoService.updateById(demo) == 1){
            return Result.success();
        }
        return Result.error();
    }
    @GetMapping("/selectById")
    Result selectById(Integer id){
        Demo demo = new Demo();
        demo.setId(id);
        Demo newDemo = demoService.selectById(demo);
        return Result.success(newDemo);
    }



}
