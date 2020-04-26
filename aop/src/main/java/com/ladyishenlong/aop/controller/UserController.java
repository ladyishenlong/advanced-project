package com.ladyishenlong.aop.controller;

import com.ladyishenlong.aop.annotation.LogRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ruanchenhao
 * @Date 2020/4/26 11:29 上午
 */
@RestController
public class UserController {


    @LogRecord("测试接口")
    @GetMapping("/{id}")
    public Object getUser(@PathVariable int id) {
        if (true) throw new RuntimeException("抛出异常");
        return "hello " + id;
    }

}
