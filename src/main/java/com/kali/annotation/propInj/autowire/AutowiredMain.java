package com.kali.annotation.propInj.autowire;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiredMain {
    @Test
    public void testSerive(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beanScanner01.xml");
        AutowiredService autowiredService = ctx.getBean("autowiredService", AutowiredService.class);
        System.out.println(autowiredService);
        autowiredService.add();
    }
}
