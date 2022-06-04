package com.kali.xml.propInj.objColltions;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ObjColltionsMain {
    // xml bean:创建Obj集合类型作为属性
    @Test
    public void objColltionsMain() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean6.xml");
        ObjColltions colorCollection = ctx.getBean("colorCollection", ObjColltions.class);

        System.out.println(colorCollection.getLists());

    }
}
