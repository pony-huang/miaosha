package com.ponking.miaosha;

import com.ponking.miaosha.dao.UserDao;
import com.ponking.miaosha.model.entity.User;
import com.ponking.miaosha.redis.RedisService;
import com.ponking.miaosha.redis.UserKey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MiaoshaApplicationTests {

    @Autowired
    private UserDao userDao;

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
