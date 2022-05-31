package com.kali;

public class SetPropertiesDemo02 {
    private SetPropertiesDemo01 obj;

    public void setObj(SetPropertiesDemo01 obj) {
        this.obj = obj;
    }

    public SetPropertiesDemo01 getObj() {
        return this.obj;
    }

    public void add(){
        System.out.println("serv add");
        obj.getValue();
    }
}
