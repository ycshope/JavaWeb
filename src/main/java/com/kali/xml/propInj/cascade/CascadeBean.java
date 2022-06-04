package com.kali.xml.propInj.cascade;

import com.kali.xml.propInj.innerBean.InnerBean;

//外部bean
public class CascadeBean {
    private InnerBean obj;

    public void setObj(InnerBean obj) {
        this.obj = obj;
    }

    public InnerBean getObj() {
        return this.obj;
    }

    public void add(){
        System.out.println("serv add");
        obj.getValue();
    }
}
