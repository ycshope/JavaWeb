package com.kali.xml.propInj.innerBean;

public class InnerBean {
    private String name;
    private int age;
    private String address;
    private String edu;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getEdu() {
        return edu;
    }

    public void getValue() {
        System.out.println("age=" + age + "\nname=" + name + "\naddress=" + address + "\nedu=" + edu);
    }
}
