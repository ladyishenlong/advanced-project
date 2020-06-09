package com.ladyishenlong.securitywebflux.utils;

import lombok.Builder;
import lombok.Data;

/**
 * @Author ruanchenhao
 * @Date 2020/6/8 2:08 下午
 */
@Data
public class RepUtils<T> {

    private int code;
    private boolean isSuccess;
    private String message;
    private T data;

    public static RepUtils success() {
        return new RepUtils();
    }


}
