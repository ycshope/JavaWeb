package com.kali.aop.aspectj.annotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//多个优先级的情况,可以用Order进行排序
//Order优先级越小值越高
@Component
@Aspect
@Order(1)
public class PersonProxy {
    @Before(value = "execution(* com.kali.aop.aspectj.annotation.User.add(..))")
    public void beforeRunning(){
        System.out.println("Person Before...");
    }
}
