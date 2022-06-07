package com.kali.aop.aspectj.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//增强的类
@Component
@Aspect //生成代理对象
public class UserProxy {

    //相同切入点抽取---相当于封装了切入方法
//    @Pointcut(value = "execution(* com.kali.aop.aspectj.annotation.User.add(..))")
    @Pointcut(value = "execution(* com.kali.aop.aspectj.annotation.User.*(..))")
    public void pointCut(){

    }

    //前置通知
    //@Before注解表示作为前置执行
    @Before(value = "pointCut()")
    public void before() {
        System.out.println("before...");
    }

    /*
     * 最终通知,不管是否成功都会执行
     * */
    @After(value = "pointCut()")
    public void after() {
        System.out.println("After...");
    }

    /*
     * 后置返回通知
     * */
    @AfterReturning(value = "pointCut()")
    public void afterReturning() {
        System.out.println("AfterReturning...");
    }

    /*
     * 后置异常通知
     * */
    @AfterThrowing(value = "pointCut()")
    public void afterThrowing() {
        System.out.println("AfterThrowing...");
    }

    /*
     * 环绕通知
     * */
    @Around(value = "pointCut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around before...");
        proceedingJoinPoint.proceed();
        System.out.println("Around after...");

    }
}
