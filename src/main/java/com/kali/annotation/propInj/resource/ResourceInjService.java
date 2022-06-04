package com.kali.annotation.propInj.resource;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ResourceInjService {
//    @Resource  //根据类型注入
    @Resource(name = "resourceInjImp01")
    private ResourceInjImp resourceInjImp;
    public void add(){
        System.out.println("ResourceInjService add...");
        resourceInjImp.add();
    }
}
