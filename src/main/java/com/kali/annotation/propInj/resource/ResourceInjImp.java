package com.kali.annotation.propInj.resource;

import org.springframework.stereotype.Component;

@Component(value = "resourceInjImp01")
public class ResourceInjImp implements ResourceInj{

    @Override
    public void add() {
        System.out.println("ResourceInjImp add...");
    }
}
