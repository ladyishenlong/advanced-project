package com.ladyishenlong.annotation.annotation.builder;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * @Author ruanchenhao
 * @Date 2020/5/6 1:49 下午
 */
@Data
@Builder
public class TestBuilderModel implements Serializable {

    @Builder.Default
    private String id  = UUID.randomUUID().toString();
    private String name;
    private String work;
    private List<String> ids;


}
