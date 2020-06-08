package com.ladyishenlong.docker;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ruanchenhao
 * @Date 2020/5/6 4:33 下午
 */
@RestController
public class TestController {

    @GetMapping
    public Object test(){
        return "访问成功";
    }

}
