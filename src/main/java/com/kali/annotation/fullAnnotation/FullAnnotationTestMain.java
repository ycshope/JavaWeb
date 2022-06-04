package com.kali.annotation.fullAnnotation;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;

public class FullAnnotationTestMain {
    @Test
    public void fullAnnotationTestMain(){
    //加载配置类
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ScannerCnf.class);
        FullAnnotationTestService fullAnnotationTestService = ctx.getBean("fullAnnotationTestService", FullAnnotationTestService.class);
        System.out.println(fullAnnotationTestService);
        fullAnnotationTestService.add();
    }
}
