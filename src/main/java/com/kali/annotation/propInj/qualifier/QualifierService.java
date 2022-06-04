package com.kali.annotation.propInj.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class QualifierService {
    @Autowired
    //根据名称进行注入(目的在于区别同一个接口下有多个实现,根据类型无法选择)
    @Qualifier(value = "qualifierInjImp01")  //相当于指定id
    private QualifierInjImpl qualifierInj;
    public void add(){
        System.out.println("QualifierService add...");
        qualifierInj.add();
    }
}
