package com.ladyishenlong.annotation.annotation.eventListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @Author ruanchenhao
 * @Date 2020/5/6 1:36 下午
 */
@Service
public class TestEventServer {

    @Autowired
    private ApplicationContext context;


    public void test() {
        context.publishEvent(new TestEvent("测试数据"));
    }

}
