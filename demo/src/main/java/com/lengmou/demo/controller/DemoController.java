package com.lengmou.demo.controller;

import com.lengmou.demo.entity.Demo;
import com.lengmou.demo.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
