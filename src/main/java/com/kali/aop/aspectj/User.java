package com.kali.aop.aspectj;


import org.springframework.stereotype.Component;

@Component
public class User {
    /**
     * 前置通知
     */
    public void add() {
        System.out.println("add...");
    }
}
