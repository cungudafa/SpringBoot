package com.springboot.three.controller;


import com.alibaba.fastjson.JSONObject;
import com.springboot.three.aop.Result;
import com.springboot.three.aop.ResultGenerator;
import com.springboot.three.entity.UserEntity;
import com.springboot.three.jpa.UserJPA;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserJPA userJPA;

    /**
     * 返回aop封装之后的内容：
     * @param num
     * @return
     */
    @RequestMapping(value="/abc",method = RequestMethod.POST)
    public Object testException(Integer num){
        int i = 5/num;//分母不为0，会报错400
        return i;
    }
    //aop测试：【post类型，成功：有返回值，失败：无返回值】
    @RequestMapping(value ="/aop",method = RequestMethod.POST)
    public Result aopTest2(Integer num,Result result,Exception e) {
        int i = 5/num;//分母不为0，会报错400
        return ResultGenerator.genSuccessResult();
    }

    //aop测试：【post类型，有返回值】
    @RequestMapping(value ="/aop/check",method = RequestMethod.POST)
    public Result aopTest(String name, Long password,Exception e) {
        UserEntity userEntity= userJPA.findByNameAndPassword(name,password);
        if(userEntity!=null){
            return ResultGenerator.genSuccessResult(userEntity);
        }else {
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    //aop测试：【get类型，有返回值】
    @RequestMapping(value = "/aop/list", method = RequestMethod.GET)
    public Result aopList(Exception e) {
        List<UserEntity> userList = userJPA.findAll();
        if(userList!=null){
            return ResultGenerator.genSuccessResult(userList);
        }else {
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }
    @RequestMapping(value = "/aop/addressList", method = RequestMethod.GET)
    public Result aopAddressList(Exception e) {
        List<UserEntity> userList = userJPA.findAll();
        if(userList!=null){
            String[] key= {"重庆","北京","上海"};//筛选条件
            ArrayList num = new ArrayList();//数据统计
            for(String keyword: key){
                List<String> AddressList = new ArrayList<>();//每次都会清空筛选条件
                AddressList.add(keyword);// 需要筛选的条件
                List<UserEntity> result = userList.stream()
                        .filter((UserEntity s) -> AddressList.contains(s.getAddress()))
                        .collect(Collectors.toList());
                num.add(result.size());//符合条件的统计结果添加到数据统计num[]中
                log.info(String.valueOf("address:"+key +"num:"+ num));//前面要加上@Slf4j标签即可使用
            }
            JSONObject map = new JSONObject();
            map.put("address", key);
            map.put("num", num);
            log.info(String.valueOf(map));
            return ResultGenerator.genSuccessResult(map);
        }else {
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }
    @RequestMapping(value = "/aop/ageList", method = RequestMethod.GET)
    public Result aopAgeList(Exception e) {
        List<UserEntity> userList = userJPA.findAll();
        if(userList!=null){
            Integer[] key= {19,20,21,22};
            ArrayList num = new ArrayList();
            for(Integer keyword: key){
                List<Integer> AgeList = new ArrayList<>();
                AgeList.add(keyword);// 需要筛选的条件
                List<UserEntity> result = userList.stream()
                        .filter((UserEntity s) -> AgeList.contains(s.getAge()))
                        .collect(Collectors.toList());
                num.add(result.size());
                log.info(String.valueOf("age:"+key +"num:"+ num));
            }
            JSONObject map = new JSONObject();
            map.put("age", key);
            map.put("num", num);
            log.info(String.valueOf(map));
            return ResultGenerator.genSuccessResult(map);
        }else {
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }


    /**
     * 返回data
     * @param name
     * @param password
     * @return
     */
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

