package com.ladyishenlong.annotation;

import com.ladyishenlong.annotation.annotation.eventListener.TestEventServer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AnnotationApplicationTests {

    @Autowired
    private TestEventServer testEventServer;

    @Test
    void contextLoads() {
        testEventServer.test();
    }

}
