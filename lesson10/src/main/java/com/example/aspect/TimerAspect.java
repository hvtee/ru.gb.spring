package com.example.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class TimerAspect {
    @Pointcut("within(@com.example.aspect.Timer *)")
    public void beansAnnotatedWith() {
    }

    @Pointcut("within(@com.example.aspect.Timer *)")
    public void methodsAnnotatedWith() {
    }

    @Around("beansAnnotatedWith()||methodsAnnotatedWith()")
    public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        var resultTime = joinPoint.proceed();
        long endTime = System.currentTimeMillis() - startTime;
        log.info("{} - {} : {} ms", joinPoint.getTarget().getClass(), joinPoint.getSignature().getName(), endTime);

        return resultTime;
    }
}
