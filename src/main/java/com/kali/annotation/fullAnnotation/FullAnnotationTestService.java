package com.kali.annotation.fullAnnotation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FullAnnotationTestService {
    @Resource(name = "fullAnnotationTest01")
    private FullAnnotationTestImpl fullAnnotationTest;
    public void add(){
        System.out.println("FullAnnotationTestService add...");
        fullAnnotationTest.add();
    }
}
