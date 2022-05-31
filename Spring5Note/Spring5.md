# Spring概念

# IOC容器

## 入门案例

前置条件

```java
SpringDemo01#
public class SpringDemo01 {
    public void test(){
        System.out.println("Hello Spring");
    }
}
```

**1.Spring配置SpringDemo01对象创建**

```xml
#resources/bean1.xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- bean definitions here -->
    <bean id="hellospring" class="com.kali.SpringDemo01"></bean>
</beans>
```

**2.创建对象**

```java
package com.kali;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        testHello();

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

}
```

## 概念

### 1、什么是IOC（控制反转）

1. 把对象创建和对象之间的调用过程，交给Spring进行管理

 	2. 使用IOC目的：为了降低耦合度
 	3. 做入门案例就是IOC实现

###  **2、IOC底层**

 a）[xml](https://so.csdn.net/so/search?q=xml&spm=1001.2101.3001.7020)解析、工厂模式、反射

### 3、画图解释IOC底层原理

**版本1.原始方式调用对象**

![image-20220529190336059](images\image-20220529190336059.png)

**版本2.工厂模式改建**

改工厂类路径就行

![image-20220529190437449](images\image-20220529190437449.png)



**版本3.IOC改进**

路径变化时只需要改bean就可以

![image-20220529190215319](images\image-20220529190215319.png)

###  4、Spring提供的IOC容器实现的两种方式（两个接口）

 a）BeanFactory接口：IOC容器基本实现是Spring内部接口的使用接口，不提供给开发人员进行使用（**加载配置文件时候不会创建对象，在获取对象时才会创建对象。**）

 b）ApplicationContext接口：BeanFactory接口的子接口，提供更多更强大的功能，提供给开发人员使用（**加载配置文件时候就会把在配置文件对象进行创建**）**推荐使用**！

## IOC容器-Bean管理

1. IOC操作Bean管理

 	Bean管理就是两个操作：（1）Spring创建对象；（2）Spring注入属性

 2. bean管理操作的两种方式

    （1）基于xml配置文件方式；（2）基于注解

     **基于XML配置文件创建对象**

    ```java
    <bean id="hellospring" class="com.kali.SpringDemo01"></bean>
    ```

3. 基于XML方式注入属性（DI：依赖注入（注入属性））

   a) spring方式注入

   ```xml
   #bean2.xml
   <bean id="setPropertiesDemo01" class="com.kali.SetPropertiesDemo01">
           <property name="age" value="10"></property>
           <property name="name" value="Hello"></property>
   </bean>
   ```

​		b) 有参构造

```xml
<!-- 有参数构造   -->
<bean id="constructorArgDemo01" class="com.kali.ConstructorArgDemo01">
    <constructor-arg name="name" value="Hello"></constructor-arg>
</bean>
```

​		c) p名称空间注入（了解即可）

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p" 
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- bean definitions here -->

    <!-- p空间注入   -->
    <bean id="pSpace" class="com.kali.SetPropertiesDemo01" p:name="pSpace" p:age="101">
    </bean>
</beans>
```

d) 入空值和特殊符号

```xml
    <bean id="setPropertiesDemo01" class="com.kali.SetPropertiesDemo01">

        <property name="age" value="10"></property>
        <!-- 注入空值 -->
        <property name="name">
            <null></null>
        </property>

        <!--   特殊值处理:1.转义     -->
        <property name="address" value="&lt;China&gt;"></property>

        <!--   特殊值处理:1.CDTA     -->
        <property name="edu">
            <value><![CDATA[<Hogwarts>]]></value>
        </property>

    </bean>
```

5. 注入属性-外部bean

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="
           http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
   
       <!-- bean definitions here -->
   
       <!-- 注入对象
           ref:引用的对象   -->
       <bean id="setPropertiesDemo02" class="com.kali.SetPropertiesDemo02">
           <property name="obj" ref="setPropertiesDemo01"></property>
   
       </bean>
       <bean id="setPropertiesDemo01" class="com.kali.SetPropertiesDemo01">
   
           <property name="age" value="10"></property>
           <property name="name">
               <null></null>
           </property>
           <property name="address" value="&lt;USA&gt;"></property>
           <property name="edu">
               <value><![CDATA[<Hogwarts>]]></value>
           </property>
   
       </bean>
   </beans>
   ```

   6. 基于XML方式注入内部bean和级联赋值

      ```xml
      <!-- 内部bean  -->
          <bean id="setPropertiesDemo021" class="com.kali.SetPropertiesDemo02">
              <property name="obj">
                  <bean id="obj" class="com.kali.SetPropertiesDemo01">
                      <property name="age" value="10"></property>
                      <property name="name">
                          <null></null>
                      </property>
                      <property name="address" value="&lt;USB&gt;"></property>
                      <property name="edu">
                          <value><![CDATA[<Hogwarts>]]></value>
                      </property>
                  </bean>
              </property>
          </bean>
      
       <!--  级联赋值  -->
          <bean id="setPropertiesDemo022" class="com.kali.SetPropertiesDemo02">
              <!--  需要外部定义setPropertiesDemo01  -->
              <property name="obj" ref="setPropertiesDemo01"></property>
              <property name="obj.age" value="101"></property>
              <property name="obj.name" value="Max"></property>
              <property name="obj.address" value="&lt;USC&gt;"></property>
              <property name="obj.edu" value="kali"></property>
          </bean>
      ```

      7. xml 注入集合属性
      
         ```xml
         <bean id="setCollections" class="com.kali.SetCollections">
             <!--        注入数组类型-->
             <property name="arr">
                 <array>
                     <value>neo</value>
                     <value>kali</value>
                 </array>
                 <!--            注入列表类型-->
             </property>
             <property name="list">
                 <list>
                     <value>papazi</value>
                     <value>pipimei</value>
                 </list>
             </property>
             <!--            注入map类型-->
             <property name="maps">
                 <map>
                     <entry key="JAVA" value="java"></entry>
                     <entry key="PHP" value="php"></entry>
                 </map>
             </property>
             <!--        set类型注入-->
             <property name="sets">
                 <set>
                     <value>MySQL</value>
                     <value>Redis</value>
                 </set>
             </property>
         </bean>
         ```
      
      8. 在集合里面设置对象类型值
      
         ```xml
         <!-- S1:在spring配置文件中引入名称空间util-->
         <beans xmlns="http://www.springframework.org/schema/beans"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xmlns:util="http://www.springframework.org/schema/util"
                xsi:schemaLocation="
                 http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
                 http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd">
         
             <!-- bean definitions here -->
         <!--S2:用util标签完成list集合注入提取-->
         <!--  1.提取list集合类属性注入  -->
             <util:list id="colorList">
                 <value>Red</value>
                 <value>Yellow</value>
                 <value>Blue</value>
             </util:list>
         
         <!--  2.提取list集合类型属性注入使用  -->
             <bean id="colorCollection" class="com.kali.SetObjColltions">
                 <property name="lists" ref="colorList"></property>
             </bean>
         </beans>
         ```

# Aop

# JdbcTemplate

# 事务管理