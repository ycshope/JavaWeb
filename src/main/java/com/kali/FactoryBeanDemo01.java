package com.kali;

import org.springframework.beans.factory.FactoryBean;

// 1.创建类,让这个类作为工厂bean,实现接口FactoryBean
public class FactoryBeanDemo01 implements FactoryBean <ConstructorArgDemo01>{

    // 2.实现接口里面的方法,在实现的方法中定义返回的bean类型
    @Override
    public ConstructorArgDemo01 getObject() throws Exception {
        ConstructorArgDemo01 constructorArgDemo01 = new ConstructorArgDemo01();
        constructorArgDemo01.setName("abc");
        return constructorArgDemo01;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
