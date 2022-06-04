package com.kali.annotation.objCre;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationMain {
    public static void main(String[] args) {
        testScanner02();
    }

    public static void testAnnotation01() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beanScanner01.xml");
        AnnotationDemo01 annotationDemo01 = ctx.getBean("annotationDemo01", AnnotationDemo01.class);
        System.out.println(annotationDemo01);
        annotationDemo01.add();
    }

    public static void testScanner02() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beanScanner02.xml");
        AnnotationDemo01 annotationDemo01 = ctx.getBean("annotationDemo01", AnnotationDemo01.class);
        System.out.println(annotationDemo01);
        annotationDemo01.add();
    }
}
