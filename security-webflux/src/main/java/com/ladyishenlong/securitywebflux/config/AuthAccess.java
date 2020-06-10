package com.ladyishenlong.securitywebflux.config;

import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @Author ruanchenhao
 * @Date 2020/6/9 4:57 下午
 */
@Slf4j
@Component
public class AuthAccess {


    public String getToken(AuthorizationContext context) {
        String token = context.getExchange()
                .getRequest().getHeaders()
                .getFirst(HttpHeaders.AUTHORIZATION);
        return token;
    }

    /**
     * @param context
     * @return 返回token中的信息
     */
    public Object verifyToken(AuthorizationContext context) {
        String token = getToken(context);
        if (StringUtil.isNullOrEmpty(token)) {
            throw new RuntimeException("token为空");
        } else {
            //todo 对token进行校验
        }
        return null;
    }


    public Mono<AuthorizationDecision> hasRoles(AuthorizationContext context, String... role) {

        Object tokenMessage = verifyToken(context);
        //todo 查看角色

        log.info("查看角色：{}",role);


        return Mono.just(new AuthorizationDecision(true));
    }



}
