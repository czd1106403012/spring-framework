package com.istudy.dada;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    public MyAspect() {
        System.out.println("MyAspect construct");
    }

    @Pointcut("execution(* com.istudy.dada.Color2.test())")
    public void pointcut(){}

    @Before("pointcut()")
    public void before() {
        System.out.println("before");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("after");
    }
}
