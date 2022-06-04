package com.kali.xml.propInj.colltions;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionsMain {
    // xml bean:设置集合类型作为属性
    @Test
    public void collectionsMain() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean5.xml");
        Collections collections = ctx.getBean("collections", Collections.class);

        collections.getAll();
    }
}
