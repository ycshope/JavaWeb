package com.kali.aop.aspectj.xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJXmlMain {
    @Test
    public void aspectJXmlMain() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beanAopXml.xml");
        Book book = ctx.getBean("book", Book.class);
        book.buy();
    }
}
