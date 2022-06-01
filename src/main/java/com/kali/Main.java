package com.kali;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        testFactoryBean06();

    }

    @Test
    public static void testHello() {
        //1.加载spring配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean1.xml");

        //2.获取配置创建的对象
        SpringDemo01 hellospring = ctx.getBean("hellospring", SpringDemo01.class);

        System.out.println(hellospring);
        hellospring.test();
    }

    @Test
    public static void testSetProperties() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean2.xml");
        SetPropertiesDemo01 setPropertiesDemo01 = ctx.getBean("setPropertiesDemo01", SetPropertiesDemo01.class);

        System.out.println(setPropertiesDemo01);
        setPropertiesDemo01.getValue();

    }

    @Test
    public static void testConstructorArgDemo() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean3.xml");
        ConstructorArgDemo01 constructorArgDemo01 = ctx.getBean("constructorArgDemo01", ConstructorArgDemo01.class);

        System.out.println(constructorArgDemo01.getName());
    }

    public static void testSetObjAsProperties() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean4.xml");
        SetPropertiesDemo02 constructorArgDemo02 = ctx.getBean("setPropertiesDemo02", SetPropertiesDemo02.class);

        constructorArgDemo02.add();

    }

    public static void testSetObjAsProperties02() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean4.xml");
        SetPropertiesDemo02 constructorArgDemo02 = ctx.getBean("setPropertiesDemo021", SetPropertiesDemo02.class);

        constructorArgDemo02.add();

    }

    // xml bean:设置对象作为属性
    public static void testSetObjAsProperties03() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean4.xml");
        SetPropertiesDemo02 constructorArgDemo02 = ctx.getBean("setPropertiesDemo022", SetPropertiesDemo02.class);

        constructorArgDemo02.add();

    }

    // xml bean:设置集合类型作为属性
    public static void testSetColASProperties04() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean5.xml");
        SetCollections setCollections = ctx.getBean("setCollections", SetCollections.class);

        setCollections.getAll();
    }

    // xml bean:创建Obj集合类型作为属性
    public static void testSetObjColltions05() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean6.xml");
        SetObjColltions colorCollection = ctx.getBean("colorCollection", SetObjColltions.class);

        System.out.println(colorCollection.getLists());

    }

    // FactoryBean: 返回类型和定义类型可以不一样
    public static void testFactoryBean06() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean7.xml");
        ConstructorArgDemo01 factoryBeanDemo01 = ctx.getBean("factoryBeanDemo01", ConstructorArgDemo01.class);  //返回类型和定义类型不是定义的bean类型
        System.out.println(factoryBeanDemo01.getName());
    }

}