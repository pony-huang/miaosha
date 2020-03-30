package com.ponking.miaosha;

import com.ponking.miaosha.dao.MiaoshaUserDao;
import com.ponking.miaosha.redis.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MiaoshaApplicationTests {

    @Autowired
    private MiaoshaUserDao miaoshaUserDao;

    @Autowired
    private RedisService redisService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testDataSource(){
    }

    @Test
    public void testRedisService(){

    }

}
