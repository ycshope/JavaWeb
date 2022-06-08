package com.kali.aop.aspectj.fullannotation;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AspectJFullAntMain {
    @Test
    public void aspectJFullAntMain(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(CnfScanner.class);
        Base base = ctx.getBean("base", Base.class);
        base.say();
    }
}
