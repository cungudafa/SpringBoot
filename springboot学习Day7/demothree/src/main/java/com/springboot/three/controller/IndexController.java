package com.springboot.three.controller;

import com.alibaba.fastjson.JSON;
import com.springboot.three.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
//实现跨域注解
//origin="*"代表所有域名都可访问
//maxAge飞行前响应的缓存持续时间的最大年龄，简单来说就是Cookie的有效期 单位为秒
//若maxAge是负数,则代表为临时Cookie,不会被持久化,Cookie信息保存在浏览器内存中,浏览器关闭Cookie就消失
@CrossOrigin(origins = "*",maxAge = 3600)
public class IndexController {
    @RequestMapping(value = "/cors")
    public String corsIndex(){
        return "this is cors info";
    }

    @RequestMapping(value="/send_message",produces = "text/json;charset=UTF-8")
    public String send_message(UserEntity pojo) throws Exception {
        log.info("执行了controller.send_message方法");
        return JSON.toJSONString(pojo);
    }

}























