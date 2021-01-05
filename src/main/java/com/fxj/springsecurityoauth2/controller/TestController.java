package com.fxj.springsecurityoauth2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    public String test1(){
        return "test1";
    }

    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    public String test2(){
        return "test2";
    }
}
