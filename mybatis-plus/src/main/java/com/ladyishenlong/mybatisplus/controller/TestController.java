package com.ladyishenlong.mybatisplus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ladyishenlong.mybatisplus.mapper.UserMapper;
import com.ladyishenlong.mybatisplus.model.UserEntity;
import com.ladyishenlong.mybatisplus.server.UserServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ruanchenhao
 * @Date 2020/4/23 10:10 上午
 */
@Slf4j
@RestController
public class TestController {

    @Autowired
    private UserServer userServer;


    @GetMapping
    public Object test() {

        IPage<UserEntity> page = new Page<>();
        page.setCurrent(0); //当前页
        page.setSize(1);    //每页条数
        userServer.page(page);

        userServer.getUserById("666");

        return  userServer.list(new QueryWrapper<UserEntity>()
                .lambda()
                .eq(UserEntity::getId,"666"));


    }



}
