package com.kali.annotation.propInj.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutowiredService {
    //定义AutowiredInjImp
    //不需要添加set方法
    //添加注入属性注解
    @Autowired //根据类型注入--需要找实现类byType
    private AutowiredInjImp autowiredInjImp;

    public void add() {
        System.out.println("service add...");
        autowiredInjImp.add();
    }
}
