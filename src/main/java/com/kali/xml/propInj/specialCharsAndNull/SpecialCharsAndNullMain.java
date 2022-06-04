package com.kali.xml.propInj.specialCharsAndNull;

import com.kali.xml.propInj.innerBean.InnerBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpecialCharsAndNullMain {
    @Test
    public void specialCharsAndNullMain() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean2.xml");
        InnerBean innerBean = ctx.getBean("setPropertiesDemo01", InnerBean.class);

        System.out.println(innerBean);
        innerBean.getValue();

    }
}
