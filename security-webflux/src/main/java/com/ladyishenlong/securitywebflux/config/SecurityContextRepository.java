package com.ladyishenlong.securitywebflux.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import javax.annotation.Resources;

/**
 * @Author ruanchenhao
 * @Date 2020/6/9 4:04 下午
 */
@Slf4j
@Component
public class SecurityContextRepository implements ServerSecurityContextRepository {



    @Override
    public Mono<Void> save(ServerWebExchange exchange, SecurityContext context) {
        return Mono.empty();
    }


    @Override
    public Mono<SecurityContext> load(ServerWebExchange exchange) {

        ServerHttpRequest request = exchange.getRequest();
        String token = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        log.info("查看token:{}", token);

        Authentication auth = new UsernamePasswordAuthenticationToken(token, token);


        return Mono.just(new SecurityContextImpl(auth));


//        return Mono.empty();
    }


}
