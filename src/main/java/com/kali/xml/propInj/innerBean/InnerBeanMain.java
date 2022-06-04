package com.kali.xml.propInj.innerBean;

import com.kali.xml.propInj.refBean.RefBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InnerBeanMain {
    //内部bean
    @Test
    public void innerBeanMain() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean4.xml");
        RefBean constructorArgDemo02 = ctx.getBean("setPropertiesDemo021", RefBean.class);

        constructorArgDemo02.add();

    }
}
