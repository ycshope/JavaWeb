package com.kali;

public class AutoWriteDemo01 {
//    自动写入:byName要求属性的名称(demo01)和bean id(demo01)一致
    private DomainDemo01 demo01;

    public void setDemo01(DomainDemo01 demo01) {
        this.demo01 = demo01;
    }

    @Override
    public String toString() {
        return "AutoWriteDemo01{" +
                "demo01=" + demo01 +
                '}';
    }

}
