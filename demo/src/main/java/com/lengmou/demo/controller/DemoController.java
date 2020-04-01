package com.lengmou.demo.controller;

import com.lengmou.demo.entity.Demo;
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
    int insert(@RequestBody Demo demo){
        return demoService.insert(demo);
    }

}
