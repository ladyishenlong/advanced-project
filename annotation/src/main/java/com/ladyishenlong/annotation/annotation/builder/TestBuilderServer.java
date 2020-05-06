package com.ladyishenlong.annotation.annotation.builder;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @Author ruanchenhao
 * @Date 2020/5/6 1:51 下午
 */
@Service
public class TestBuilderServer {

    public void build() {
        TestBuilderModel.builder()
                .name("名称")
                .work("工作")
                .ids(new ArrayList<>())
                .build();
    }

}
