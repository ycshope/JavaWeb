package com.kali.annotation.propInj.resource;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ResourceInjMain {
    @Test
    public void testResourceInjMain(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beanScanner01.xml");
        ResourceInjService resourceInjService = ctx.getBean("resourceInjService", ResourceInjService.class);
        System.out.println(resourceInjService);
        resourceInjService.add();
    }
}
