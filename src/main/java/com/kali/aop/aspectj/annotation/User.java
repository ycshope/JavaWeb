package com.kali.aop.aspectj.annotation;


import org.springframework.stereotype.Component;

@Component
public class User {
    /**
     * 前置通知
     */
    public void add() {
        System.out.println("add...");
    }

    public void ecp() {
        int a = 10 / 0;
        System.out.println("ecp ...");

    }
}
