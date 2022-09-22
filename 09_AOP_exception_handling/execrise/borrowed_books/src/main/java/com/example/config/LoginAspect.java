package com.example.config;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class LoginAspect {
    int count = 0;

    @Pointcut("within(com.example.controller.BookController*)")
    public void allMethodPointCut() {
    }

    @After("allMethodPointCut()")
    public void beforeCallMethod(JoinPoint joinPoint) {
        count++;
        System.err.println("start method name" + joinPoint.getSignature().getName() + " số lần ghé thăm thư viện " + count);
    }

    @Pointcut("execution(* com.example.controller.BookController.get*(..))")
    public void afterAllMethodPointCut() {
    }

    @After("afterAllMethodPointCut()")
    public void afterCallMethod(JoinPoint joinPoint) {
        System.err.println("start method name" + joinPoint.getSignature().getName() + " Time " + LocalDateTime.now());
    }
}
