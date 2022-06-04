package com.kali.annotation.fullAnnotation;

import org.springframework.stereotype.Component;

import javax.print.attribute.standard.MediaSize;

@Component(value = "fullAnnotationTest01")
public class FullAnnotationTestImpl implements FullAnnotationTest {
    @Override
    public void add() {
        System.out.println("fullAnnotationTestImpl add...");
    }
}
