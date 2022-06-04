package com.kali.xml.objCre;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorWithOutArgMain {

    @Test
    public void testHello() {
        //1.加载spring配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean1.xml");

        //2.获取配置创建的对象
        ConstructorWithOutArg hellospring = ctx.getBean("hellospring", ConstructorWithOutArg.class);

        System.out.println(hellospring);
        hellospring.test();
    }
}
