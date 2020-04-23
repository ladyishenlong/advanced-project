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

import java.util.Date;

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

        //分页查询
        IPage<UserEntity> page = new Page<>();
        page.setCurrent(0); //当前页
        page.setSize(1);    //每页条数
        userServer.page(page, new QueryWrapper<UserEntity>().lambda()
                .eq(UserEntity::getId, "666"));

        //xml分页查询
        Page<UserEntity> userEntityPage = new Page<>();
        userEntityPage.setCurrent(0);
        userEntityPage.setSize(1);
        IPage<UserEntity> userEntityIPage = userServer.getUserPage(userEntityPage);


        //xml语句
        userServer.getUserById("666");
        //自动生成查询
        userServer.list(new QueryWrapper<UserEntity>().lambda()
                .eq(UserEntity::getId, "666"));


        return userEntityIPage;

    }


    @GetMapping("/test2")
    public Object test2() {

        //插入数据，可以添加事务
        UserEntity userEntity = new UserEntity();
        userEntity.setId("2500");
        userEntity.setName("黑魔导");
        userEntity.setPhone("2500");
        userEntity.setUsername("2500");
        userServer.saveUser(userEntity);



        return "";
    }


}
