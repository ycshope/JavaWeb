package com.kali.annotation.propInj.qualifier;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QualifierInjMain {
    @Test
    public void testQualifierInj(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beanScanner01.xml");
        QualifierService qualifierService = ctx.getBean("qualifierService", QualifierService.class);
        System.out.println(qualifierService);
        qualifierService.add();
    }
}
