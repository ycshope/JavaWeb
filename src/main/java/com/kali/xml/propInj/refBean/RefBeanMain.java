package com.kali.xml.propInj.refBean;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RefBeanMain {
    @Test
    public void refBeanMain() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean4.xml");
        RefBean constructorArgDemo02 = ctx.getBean("setPropertiesDemo02", RefBean.class);

        constructorArgDemo02.add();

    }
}
