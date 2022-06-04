package com.kali.xml.propInj.liveSpan;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLiveSpanMain {
    // bean 的生命周期
    @Test
    public void testBeanLiveSpan() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean9.xml");
        BeanLiveSpan beanLiveSpan = ctx.getBean("beanLiveSpan", BeanLiveSpan.class);
        System.out.println("第四步:创建bean实例");
        System.out.println(beanLiveSpan);

        //手动销毁bean实例
        ctx.close();
    }
}
