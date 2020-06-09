package com.ladyishenlong.securitywebflux.controller;

import com.ladyishenlong.securitywebflux.model.UserModel;
import com.ladyishenlong.securitywebflux.utils.RepUtils;
import io.netty.util.internal.SuppressJava6Requirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * @Author ruanchenhao
 * @Date 2020/6/8 9:32 上午
 */

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public Mono<RepUtils> hello(){
        return Mono.just(RepUtils.success());
    }

    @PostMapping
    public Mono<RepUtils> hello2(@RequestBody UserModel userModel){
        log.info("查看信息：{}",userModel);
        return Mono.just(RepUtils.success());
    }

}
