package com.ladyishenlong.aop.aspect;

import com.ladyishenlong.aop.annotation.LogRecord;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;


/**
 * @Author ruanchenhao
 * @Date 2020/4/26 11:58 上午
 */
@Slf4j
@Aspect
@Component
public class LogAspect {


    @Pointcut(value = "@annotation(com.ladyishenlong.aop.annotation.LogRecord)")
    public void pointCut() {

    }


    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        //获得执行的结果,controller里的异常在这步抛出
        Object result = joinPoint.proceed();
        log.info("接口返回值：{}", result);


        HttpServletRequest request = ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getRequest();

        String requestUri = request.getRequestURI();
        log.info("查看访问地址:{}", requestUri);


        //获取参数
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        HashMap<String, Object> paramMap = new HashMap<>();
        for (int i = 0; i < joinPoint.getArgs().length; i++) {
            String paramName = methodSignature.getParameterNames()[i];
            Object paramValue = joinPoint.getArgs()[i];
            paramMap.put(paramName, paramValue);
        }
        log.info("查看参数：{}", paramMap.toString());



        //获取注解内信息
        LogRecord logRecord = methodSignature.getMethod().getAnnotation(LogRecord.class);
        log.info("查看日志信息：{}", logRecord.value());


        return result;
    }


    private Method getMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取参数的类型
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        return joinPoint.getTarget().getClass().getMethod(
                joinPoint.getSignature().getName(),
                methodSignature.getParameterTypes());
    }


    @AfterReturning(pointcut = "pointCut()", returning = "rvt")
    public void doAfterReturning(JoinPoint joinPoint, Object rvt) {
        // 处理日志信息
        log.info("正常完成接口后日志：{}", rvt);
    }



}
