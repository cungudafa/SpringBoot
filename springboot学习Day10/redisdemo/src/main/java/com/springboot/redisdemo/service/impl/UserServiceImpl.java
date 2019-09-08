package com.springboot.redisdemo.service.impl;

import com.springboot.redisdemo.entity.UserEntity;
import com.springboot.redisdemo.jpa.UserJPA;
import com.springboot.redisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserJPA userJPA;

    /**
     * 2、在 Service 层的实现类中的方法@缓存
     * ,keyGenerator="keyGenerator"指定缓存的 key，为KeyGenerator 的 bean
     */
    @Override
    @Cacheable(value = "userList")
    public List<UserEntity> list() {
        return userJPA.findAll();
    }

}
