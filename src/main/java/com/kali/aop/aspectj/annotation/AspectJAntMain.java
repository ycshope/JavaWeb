package com.kali.aop.aspectj.annotation;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJAntMain {
    @Test
    public void testAspectJ(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beanAspectJScanner01.xml");
        User user = ctx.getBean("user", User.class);
        //正常4个切入点测试
        user.add();
        System.out.println("==========");
        //切入点异常测试
        user.ecp();
    }
}
