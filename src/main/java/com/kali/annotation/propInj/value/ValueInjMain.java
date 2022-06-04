package com.kali.annotation.propInj.value;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ValueInjMain {
    @Test
    public void testValueInj(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beanScanner01.xml");
        ValueInjImp valueInjImp = ctx.getBean("valueInjImp", ValueInjImp.class);
        System.out.println(valueInjImp);
        System.out.println(valueInjImp.getName());
    }
}
