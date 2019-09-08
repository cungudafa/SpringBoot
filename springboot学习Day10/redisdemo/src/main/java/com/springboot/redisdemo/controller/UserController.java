package com.springboot.redisdemo.controller;

import com.springboot.redisdemo.entity.UserEntity;
import com.springboot.redisdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    // http://localhost:8080/list
    @GetMapping(value="/list")
    public List<UserEntity> list(){
        System.out.println("只有第一次才会打印sql语句");
        return userService.list();
    }

}

