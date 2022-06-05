package com.kali.aop.aspectj;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJMain {
    @Test
    public void testAspectJ(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beanAspectJScanner01.xml");
        User user = ctx.getBean("user", User.class);
        user.add();
    }
}
