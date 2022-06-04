package com.kali.annotation.propInj.qualifier;

import org.springframework.stereotype.Component;

@Component(value = "qualifierInjImp01") //修改为名称注入
public class QualifierInjImpl implements QualifierInj {
    @Override
    public void add() {
        System.out.println("QualifierInjImpl add...");
    }
}
