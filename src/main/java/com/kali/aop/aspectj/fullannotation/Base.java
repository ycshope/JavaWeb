package com.kali.aop.aspectj.fullannotation;

import org.springframework.stereotype.Component;

@Component
public class Base {
    public void say(){
        System.out.println("base...");
    }
}
