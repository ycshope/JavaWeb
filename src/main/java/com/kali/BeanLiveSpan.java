package com.kali;

public class BeanLiveSpan {

    private String name;

    public BeanLiveSpan() {
        System.out.println("第一步:执行无参构造创建bean实例");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("第二步:调用set方法设置属性值");
    }

    public void initMethod() {
        System.out.println("第三步:执行初始化的方法");
    }

    public void destroyMethod(){
        System.out.println("第五步:执行销毁的方法");
    }
}
