package com.kali.xml.propInj.refBean;

import com.kali.xml.propInj.innerBean.InnerBean;

//外部bean
public class RefBean {
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
