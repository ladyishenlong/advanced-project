package com.ladyishenlong.elasticsearch.controller;

import com.ladyishenlong.elasticsearch.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ruanchenhao
 * @Date 2020/4/24 4:05 下午
 */
@RestController
public class UserController {

    @Autowired
    private UserServer testServer;

    @GetMapping("/create")
    public Object create() {
        testServer.createIndex();
        return "";
    }


    @GetMapping("/save")
    public Object save() {
        testServer.saveUsers();
        return "";
    }

    @GetMapping("/find")
    public Object find() {
        return testServer.findAll();
    }

    @GetMapping("/search")
    public Object search() {
        return testServer.search();
    }

    @GetMapping("/query")
    public Object query() {
        return testServer.query();
    }

}
