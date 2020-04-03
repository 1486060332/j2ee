package com.lengmou.demo;

import cn.hutool.http.HttpRequest;
import com.lengmou.demo.util.RedisUtil;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoSpringBootTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void bingfa() {
        for(int i = 1; i <= 10; i++) {
            int temp = i;
            new Thread(()->{
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("id", 1);
                    jsonObject.put("reduceNumber", temp);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String body = HttpRequest.post("localhost:8080/good/reduceStock").body(jsonObject.toString()).execute().body();
                System.out.println(body);
            }).start();
        }
    }

    @Test
    public void feibingfa(){
        for(int i = 1; i < 11; i++){
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("id", 1);
                jsonObject.put("reduceNumber", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            String body = HttpRequest.post("localhost:8080/good/reduceStock").body(jsonObject.toString()).execute().body();
            System.out.println(body);
        }
    }
}
