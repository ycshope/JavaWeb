package com.kali.xml.propInj.cascade;

import com.kali.xml.propInj.refBean.RefBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CascadeBeanMain {
    // xml bean:设置对象作为属性 --级联bean
    @Test
    public void testSetObjAsProperties03() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean4.xml");
        RefBean constructorArgDemo02 = ctx.getBean("setPropertiesDemo022", RefBean.class);

        constructorArgDemo02.add();

    }
}
