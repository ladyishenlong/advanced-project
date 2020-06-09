package com.ladyishenlong.securitywebflux.config;

import org.springframework.http.HttpHeaders;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;

/**
 * @Author ruanchenhao
 * @Date 2020/6/9 4:57 下午
 */
@Component
public class AuthAccess {


    public String getToken(AuthorizationContext context){
        String token = context.getExchange().getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        return token;
    }

}
