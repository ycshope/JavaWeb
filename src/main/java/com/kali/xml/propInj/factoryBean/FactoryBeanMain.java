package com.kali.xml.propInj.factoryBean;

import com.kali.xml.propInj.specialCharsAndNull.specialCharsAndNull;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanMain {
    // FactoryBean: 返回类型和定义类型可以不一样
    @Test
    public void factoryBeanMain() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean7.xml");
        specialCharsAndNull factoryBeanDemo01 = ctx.getBean("factoryBeanDemo01", specialCharsAndNull.class);  //返回类型和定义类型不是定义的bean类型
        System.out.println(factoryBeanDemo01.getName());
    }
}
