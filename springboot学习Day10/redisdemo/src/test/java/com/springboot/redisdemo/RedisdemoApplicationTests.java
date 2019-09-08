package com.springboot.redisdemo;

import com.springboot.redisdemo.service.RedisService;
import com.springboot.redisdemo.service.UserService;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisdemoApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        userService.list();
    }
    @Rule
    public ContiPerfRule i = new ContiPerfRule();

    /**
     * 性能测试
     * 10万次查询，100个线程同时操作list方法
     */
    @Test
    @PerfTest(invocations = 100000, threads = 100)
    public void Test2() {
        userService.list();
    }
    //======================================
    @Autowired
    RedisService redisService;

    @Test
    public void findAllUsers()  {
        redisService.addKey("key","hello", 60, TimeUnit.SECONDS);
    }


    @Test
    public void findAllUsers2()  {
        System.out.println("get key value:"+ redisService.getValue("key"));
    }

}
