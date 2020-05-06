package com.ladyishenlong.annotation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ruanchenhao
 * @Date 2020/5/6 11:23 上午
 */
@RestController
public class TestController {



    @GetMapping
    public Object test(){
        return "";
    }

}
