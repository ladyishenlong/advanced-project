package com.ladyishenlong.mybatisplus;

import com.ladyishenlong.mybatisplus.mapper.UserMapper;
import com.ladyishenlong.mybatisplus.server.UserServer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserServer userServer;

    @Test
    void contextLoads() {


    }

}
