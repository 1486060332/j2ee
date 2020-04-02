package com.lengmou.demo;
import com.lengmou.demo.entity.Demo;
import com.lengmou.demo.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoSpringBootTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void insertDemoList(){
        Set<String> keys = redisTemplate.keys("demo:*");
        System.out.println(keys);
        for (String key : keys) {
            redisUtil.del(key);
        }
    }
}
