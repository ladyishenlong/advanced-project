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


        Object object = joinPoint.proceed();

        HttpServletRequest request = ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes())
                .getRequest();

        Method method = getMethod(joinPoint);

        LogRecord logRecord = method.getAnnotation(LogRecord.class);


        log.info("查看日志信息：{}", logRecord.value());


        return null;
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
        log.info("完成后日志：{}", rvt);
    }


}
