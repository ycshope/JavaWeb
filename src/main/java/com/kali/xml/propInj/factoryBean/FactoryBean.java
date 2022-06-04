package com.kali.xml.propInj.factoryBean;

import com.kali.xml.propInj.specialCharsAndNull.specialCharsAndNull;

// 1.创建类,让这个类作为工厂bean,实现接口FactoryBean
public class FactoryBean implements org.springframework.beans.factory.FactoryBean<specialCharsAndNull> {

    // 2.实现接口里面的方法,在实现的方法中定义返回的bean类型
    @Override
    public specialCharsAndNull getObject() throws Exception {
        specialCharsAndNull specialCharsAndNull = new specialCharsAndNull();
        specialCharsAndNull.setName("abc");
        return specialCharsAndNull;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
