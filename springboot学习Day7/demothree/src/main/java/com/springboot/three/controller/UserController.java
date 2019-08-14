package com.springboot.three.controller;


import com.springboot.three.aop.Result;
import com.springboot.three.aop.ResultGenerator;
import com.springboot.three.entity.UserEntity;
import com.springboot.three.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserJPA userJPA;
    @RequestMapping(value="/abc",method = RequestMethod.POST)
    public Object testException(Integer num){
        int i = 5/num;//分母不为0，会报错400
        return i;
    }
    //aop测试：【post类型，有返回值】
    @RequestMapping(value ="/aop",method = RequestMethod.POST)
    public Result aopTest(String name, Long password,Exception e) {
        UserEntity userEntity= userJPA.findByNameAndPassword(name,password);
        if(userEntity!=null){
            return ResultGenerator.genSuccessResult(userEntity);
        }else {
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }
    //aop测试：【post类型，成功：有返回值，失败：无返回值】
    @RequestMapping(value ="/aop1",method = RequestMethod.POST)
    public Result aopTest2(Integer num,Result result,Exception e) {
        int i = 5/num;//分母不为0，会报错400
        return ResultGenerator.genSuccessResult();
    }
    //aop测试：【get类型，有返回值】
    @RequestMapping(value = "/aop2", method = RequestMethod.GET)
    public Result aopList3(Exception e) {
        List<UserEntity> userlist = userJPA.findAll();
        if(userlist!=null){
            return ResultGenerator.genSuccessResult(userlist);
        }else {
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }
    @RequestMapping(value ="/check",method = RequestMethod.POST)
    public UserEntity check(String name,Long password) {
        UserEntity userEntity= userJPA.findByNameAndPassword(name,password);
        return userEntity;
    }
    @RequestMapping(value ="/findUserByName",method = RequestMethod.GET)
    public List<UserEntity> find(String name) {
        return userJPA.findByNameLike("%"+name+"%");
    }
    @RequestMapping(value ="/findUserById",method = RequestMethod.GET)
    public Optional<UserEntity> userInfo(Long id) {
        return userJPA.findById(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<UserEntity> list() {
        return userJPA.findAll();//SpringDataJPA为我们提供的内置方法，它可以查询表内所有的数据
    }

    /**
     * 添加、更新用户方法
     * @param entity
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public UserEntity save(UserEntity entity){
        return userJPA.save(entity);
    }
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public List<UserEntity> delete(Long id){
        userJPA.deleteById(id);
        return userJPA.findAll();
    }















}

