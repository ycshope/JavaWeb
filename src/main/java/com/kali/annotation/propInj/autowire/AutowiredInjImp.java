package com.kali.annotation.propInj.autowire;

import org.springframework.stereotype.Component;

@Component //修改为名称注入
public class AutowiredInjImp implements AutowiredInj{

    @Override
    public void add() {
        System.out.println("AutowiredInjImp add...");
    }
}
