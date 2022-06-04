package com.kali.xml.propInj.domain;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DomainMain {
    // bean 作用域:
    @Test
    public void domainMain() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean8.xml");
        Domain domain = ctx.getBean("domain", Domain.class);
        Domain domainDemo02 = ctx.getBean("domain", Domain.class);
        System.out.println(domain);
        System.out.println(domainDemo02);
    }
}
