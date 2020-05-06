package com.ladyishenlong.annotation.annotation.eventListener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Author ruanchenhao
 * @Date 2020/5/6 1:24 下午
 */
@Slf4j
@Component
public class TestEventListener {

    @EventListener(TestEvent.class)
    public void testListener(TestEvent testEvent){
        log.info("查看监听信息：{}",testEvent.getSource());
    }

    @EventListener(TestEvent.class)
    public void testListener2(TestEvent testEvent){
        log.info("查看监听信息2：{}",testEvent.getSource());
    }

}
