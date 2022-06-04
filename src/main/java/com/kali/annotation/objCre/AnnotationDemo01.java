package com.kali.annotation.objCre;

import org.springframework.stereotype.Component;

//在注解里面value属性值可以省略
//默认就是类名的首字母小写
//AnnotationDemo01 -- annotationDemo01
@Component(value = "annotationDemo01")  //注解等同于XML配置文件:<bean id="annotationDemo01" class="...">
public class AnnotationDemo01 {
    public void add() {
        System.out.println("add ...");
    }
}
