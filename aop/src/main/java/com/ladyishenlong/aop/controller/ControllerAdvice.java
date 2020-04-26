package com.ladyishenlong.aop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author ruanchenhao
 * @Date 2020/4/26 2:00 下午
 * <p>
 * ControllerAdvice是对controller抛出的异常做处理，
 * aop切面如果处理了异常，则此处就无法捕获到
 */
@Slf4j
@RestControllerAdvice
public class ControllerAdvice {


    @ExceptionHandler(Exception.class)
    public Object exception(Exception exception) {
        //打印错误信息，以及堆栈跟踪
        log.error(exception.getMessage(), exception);
        return exception.getMessage();
    }

}
