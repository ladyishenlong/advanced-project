package com.ladyishenlong.securitywebflux.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author ruanchenhao
 * @Date 2020/6/8 9:36 上午
 */
@Slf4j
@EnableWebFluxSecurity
public class WebFluxSecurityConfig {


    @Autowired
    private SecurityContextRepository securityContextRepository;

    @Autowired
    private AuthAccess authAccess;

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {

        return http
                .securityContextRepository(securityContextRepository)
                //跨站请求
                .csrf().disable()
                //跨域请求
                .cors().disable()

                .authorizeExchange()

                .pathMatchers("/test/**")
                .access((mono, context) -> authAccess.hasRoles(context,"ADMIN"))

                .anyExchange().authenticated()
                .and()
                .build();
    }

}