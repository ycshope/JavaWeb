package com.kali.aop.aspectj.fullannotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect //生成代理对象
public class BaseProxy {
    @Pointcut(value = "execution(* com.kali.aop.aspectj.fullannotation.Base.say(..))")
    public void pointCut() {
    }

    @Around(value = "pointCut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around before...");
        proceedingJoinPoint.proceed();
        System.out.println("Around after...");
    }
}
