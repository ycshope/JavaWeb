package com.kali.annotation.propInj.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ValueInjImp {
    @Value(value = "Hello ValueImp")
    private String name;

    public String getName() {
        System.out.println("ValueImp getName...");
        return name;
    }
}