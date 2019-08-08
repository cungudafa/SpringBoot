package com.springboot.test2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HellowordController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String hello(){
        return "Hello!This is my first Springboot Test!";
    }
}
