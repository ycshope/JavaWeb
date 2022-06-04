package com.kali.xml.propInj.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWriteMain {
    // bean 的自动装配
    @Test
    public void autoWriteMain() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean11.xml");
        AutoWrite autoWrite = ctx.getBean("autoWrite", AutoWrite.class);
        System.out.println(autoWrite);
    }
}
