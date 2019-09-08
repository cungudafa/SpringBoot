package com.springboot.redisdemo.service;

import com.springboot.redisdemo.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    /**
     * 获取所有user
     * @return
     */
    List<UserEntity> list();
}
