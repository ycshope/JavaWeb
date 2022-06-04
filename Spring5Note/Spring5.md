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

**1、什么是IOC（控制反转）**

1. 把对象创建和对象之间的调用过程，交给Spring进行管理

 	2. 使用IOC目的：为了降低耦合度
 	3. 做入门案例就是IOC实现

**2、IOC底层**

 a）[xml](https://so.csdn.net/so/search?q=xml&spm=1001.2101.3001.7020)解析、工厂模式、反射

**3、画图解释IOC底层原理**

**版本1.原始方式调用对象**

![image-20220529190336059](images\image-20220529190336059.png)

**版本2.工厂模式改建**

改工厂类路径就行

![image-20220529190437449](images\image-20220529190437449.png)



**版本3.IOC改进**

路径变化时只需要改bean就可以

![image-20220529190215319](images\image-20220529190215319.png)

**4、Spring提供的IOC容器实现的两种方式（两个接口）**

 a）BeanFactory接口：IOC容器基本实现是Spring内部接口的使用接口，不提供给开发人员进行使用（**加载配置文件时候不会创建对象，在获取对象时才会创建对象。**）

 b）ApplicationContext接口：BeanFactory接口的子接口，提供更多更强大的功能，提供给开发人员使用（**加载配置文件时候就会把在配置文件对象进行创建**）**推荐使用**！

## IOC容器-Bean管理

1. IOC操作Bean管理

 	Bean管理就是两个操作：（1）Spring创建对象；（2）Spring注入属性

 2. bean管理操作的两种方式

    （1）基于xml配置文件方式；（2）基于注解
    

#### 基于xml配置文件方式

##### 对象创建

```xml
<bean id="hellospring" class="com.kali.SpringDemo01"></bean>
```

##### 属性注入

基于XML方式注入属性（DI：依赖注入（注入属性））

**a) spring方式注入**

```xml
#bean2.xml
<bean id="setPropertiesDemo01" class="com.kali.SetPropertiesDemo01">
        <property name="age" value="10"></property>
        <property name="name" value="Hello"></property>
</bean>
```

**b) 有参构造**

```xml
<!-- 有参数构造   -->
<bean id="constructorArgDemo01" class="com.kali.ConstructorArgDemo01">
    <constructor-arg name="name" value="Hello"></constructor-arg>
</bean>
```

**c) p名称空间注入（了解即可）**

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

**d) 入空值和特殊符号**

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

**e) 外部bean**

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

**f) 内部bean和级联赋值**

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

**g) 注入集合属性**

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

**h) 在集合里面设置对象类型值**

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

###### FactoryBean

 1、Spring 有两种类型 bean，一种普通 bean，另外一种工厂 bean（FactoryBean）

 2、普通 bean：在配置文件中定义 bean 类型就是返回类型

 3、工厂 bean：在配置文件定义 bean 类型可以和返回类型不一样 第一步 创建类，让这个类作为工厂 bean，实现接口 FactoryBean 第二步 实现接口里面的方法，在实现的方法中定义返回的 bean 类型
（工厂bean配置类型和返回类型可以不一样）

```java
// 1.创建类,让这个类作为工厂bean,实现接口FactoryBean
public class FactoryBeanDemo01 implements FactoryBean <ConstructorArgDemo01>{

    // 2.实现接口里面的方法,在实现的方法中定义返回的bean类型
    @Override
    public ConstructorArgDemo01 getObject() throws Exception {
        ConstructorArgDemo01 constructorArgDemo01 = new ConstructorArgDemo01();
        constructorArgDemo01.setName("abc");
        return constructorArgDemo01;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
```

```xml
#bean7
<bean id="factoryBeanDemo01" class="com.kali.FactoryBeanDemo01"></bean>
```

```java
    public static void testFactoryBean06() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean7.xml");
        ConstructorArgDemo01 factoryBeanDemo01 = ctx.getBean("factoryBeanDemo01", ConstructorArgDemo01.class);  //返回类型和定义类型不是定义的bean类型
        System.out.println(factoryBeanDemo01.getName());
    }
```

###### **bean 作用域**

在 Spring 里面，默认情况下，bean 是单实例对象，下面进行作用域设置：

（1）在 spring 配置文件 bean 标签里面有属性（scope）用于设置单实例还是多实例

（2）scope 属性值 第一个值 默认值，singleton，表示是单实例对象 第二个值 prototype，表示是多实例对象

```xml
 <!--  默认是单实例(地址一样), scope="prototype"是多实例 -->
    <bean id="domainDemo01" class="com.kali.DomainDemo01" scope="prototype">
        <property name="name" value="hello"></property>
    </bean>
```



（3）singleton 和 prototype 区别

​		a）singleton 单实例，prototype 多实例

 b）设置 scope 值是 singleton 时候，加载 spring 配置文件时候就会创建单实例对象 ；设置 scope 值是 prototype 时候，<u>不是在加载 spring 配置文件时候创建对象，在调用 getBean 方法时候创建多实例对象</u>

###### bean生命周期

1、生命周期 ：从对象创建到对象销毁的过程

2、bean 生命周期

 （1）通过构造器创建 bean 实例（无参数构造）

 （2）为 bean 的属性设置值和对其他 bean 引用（调用 set 方法）

 <u>（3）把 bean 实例传递 bean 后置处理器的方法 postProcessBeforeInitialization</u>  <----添加后置处理器后

 （4）调用 bean 的初始化的方法（需要进行配置初始化的方法）

 <u>（5）把 bean 实例传递 bean 后置处理器的方法 postProcessAfterInitialization</u> <----添加后置处理器后

 （6）bean 可以使用了（对象获取到了）

 （7）当容器关闭时候，调用 bean 的销毁的方法（需要进行配置销毁的方法）

3、演示 bean 生命周期 ：

```java
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
```



```java
public static void testBeanLiveSpan(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean9.xml");
        BeanLiveSpan beanLiveSpan = ctx.getBean("beanLiveSpan", BeanLiveSpan.class);
        System.out.println("第四步:创建bean实例");
        System.out.println(beanLiveSpan);

        //手动销毁bean实例
        ctx.close();
    }
```



```xml
    <!--  bean的生命周期:初始化执行方法,销毁方法 -->
    <bean id="beanLiveSpan" class="com.kali.BeanLiveSpan" init-method="initMethod" destroy-method="destroyMethod">
        <property name="name" value="hello"></property>
    </bean>

    <!--  配置后置处理器  -->
    <bean id="beanPost" class="com.kali.BeanPost"></bean>
```

###### 自动管理

就是自动填充值

```java
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
```

```xml
    <!--   自动装配:
        设置属性autowire,实现自动装配
        方式1:
            byName,注入值的bean的id值和属性名一样(属性和id均为为demo01)
        方式2:
            byType,根据属性类型注入,但是需要注意class中有两个相同类型时会有歧义导致无法注入
     -->
    <!--    <bean id="autoWriteDemo01" class="com.kali.AutoWriteDemo01" autowire="byName"></bean>-->
    <bean id="autoWriteDemo01" class="com.kali.AutoWriteDemo01" autowire="byType"></bean>
    <bean id="demo01" class="com.kali.DomainDemo01"></bean>
```



###### 外部属性文件

**引入外部属性文件配置数据库连接池**

（1）创建外部属性文件，properties 格式文件，写数据库信息（**jdbc.properties**）

```
prop.driverClass=com.mysql.jdbc.Driver
prop.url=jdbc:mysql://localhost:3306/userDb
prop.usrName=root
prop.password=root
```

（2）把外部 properties 属性文件引入到 spring 配置文件中 —— 引入 context 名称空间

```xml
    <!--  引入外部属性文件  -->
    <context:property-placeholder location="classpath:jdbc.properties"></context:property-placeholder>
    <!--引入context名称空间-->
    <!-- bean definitions here -->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${prop.driverClass}"></property>
        <property name="url" value="${prop.url}"></property>
        <property name="username" value="${prop.usrName}"></property>
        <property name="password" value="${prop.password}"></property>
    </bean>
```

#### 基于注解方式

##### 概念

1. 简化xml配置

2. 使用注解，注解作用在类上面，方法上面，属性上面

3. 注解是代码特殊标记，格式：@注解名称(属性名称=属性值, 属性名称=属性值…)

4. Spring 针对 Bean 管理中创建对象提供注解

基于注解方式实现对象创建


下面四个注解功能是一样的，都可以用来创建 bean 实例

```java
@Component
@Service
@Controller
@Repository
```

##### 创建对象

第一步 引入依赖 （引入**spring-aop jar包**）

```xml
<!--    设置aop    -->
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.6.1</version>
</parent>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

第二步 开启组件扫描

```xml
<!--引入context名称空间-->
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">
<!--  开启组件扫描
    1. 如果扫描多个包,多个包使用逗号隔开
    2. 扫描包上层目录
  -->
    <context:component-scan base-package="com.kali.annotation"></context:component-scan>
```

第三步 创建类，在类上面添加创建对象注解

```java
//在注解里面value属性值可以省略
//默认就是类名的首字母小写
//AnnotationDemo01 -- annotationDemo01
@Component(value = "annotationDemo01")  //注解等同于XML配置文件:<bean id="annotationDemo01" class="...">
public class AnnotationDemo01 {
    public void add() {
        System.out.println("add ...");
    }
}
```

###### 开启组件扫描细节配置

```xml
<!-- 开启组件扫描细节配置   -->
    <!--示例 1
     use-default-filters="false" 表示现在不使用默认 filter，自己配置 filter
     context:include-filter ，设置扫描哪些内容
    -->
    <context:component-scan base-package="com.kali.annotation" use-default-filters="false">
        <context:include-filter type="annotation"
                                expression="org.springframework.stereotype.Component"/><!--代表只扫描Component注解的类-->
    </context:component-scan>
    <!--示例 2
     下面配置扫描包所有内容
     context:exclude-filter： 设置哪些内容不进行扫描
    -->
    <context:component-scan base-package="com.kali.annotation">
        <context:exclude-filter type="annotation"
                                expression="org.springframework.stereotype.Controller"/><!--表示Controller注解的类之外一切都进行扫描-->
    </context:component-scan>
```

##### 属性注入

常见的三种注入类型	

（1）@Autowired：根据属性类型进行自动装配

（2）@Qualifier：根据名称进行注入

（3）@Resource：可以根据类型注入，也可以根据名称注入

（4）@Value：注入普通类型属性

###### @Autowired

第一步 把 service 和 dao 对象创建，在 service 和 autowiredInjImp类添加创建对象注解

```java
#创建对象
@Component
public class AutowiredInjImp implements AutowiredInj{

    @Override
    public void add() {
        System.out.println("AutowiredInjImp add...");
    }
}
```



第二步 在 service 注入 dao 对象，在 service 类添加 autowiredInjImp类型属性，在属性上面使用注解

```java
@Service
public class AutowiredService {
    //定义AutowiredInjImp
    //不需要添加set方法
    //添加注入属性注解
    @Autowired	//根据类型注入
    private AutowiredInjImp autowiredInjImp;
    public void add(){
        System.out.println("service add...");
        autowiredInjImp.add();
    }
}

```



###### @Qualifier

根据名称进行注入，这个@Qualifier 注解的使用，和上面@Autowired 一起使用

```java
@Component(value = "qualifierInjImp01") //修改为名称注入
public class QualifierInjImpl implements QualifierInj {
    @Override
    public void add() {
        System.out.println("QualifierInjImpl add...");
    }
}
```

```java
@Service
public class QualifierService {
    @Autowired
    //根据名称进行注入(目的在于区别同一个接口下有多个实现,根据类型无法选择)
    @Qualifier(value = "qualifierInjImp01")  //相当于指定id
    private QualifierInjImpl qualifierInj;
    public void add(){
        System.out.println("QualifierService add...");
        qualifierInj.add();
    }
}
```



###### @Resource

可以根据类型注入，也可以根据名称注入（它属于javax包下的注解，不推荐使用！）

```java
@Component(value = "resourceInjImp01")
public class ResourceInjImp implements ResourceInj{

    @Override
    public void add() {
        System.out.println("ResourceInjImp add...");
    }
}
```

```java
@Service
public class ResourceInjService {
//    @Resource  //根据类型注入
    @Resource(name = "resourceInjImp01")
    private ResourceInjImp resourceInjImp;
    public void add(){
        System.out.println("ResourceInjService add...");
        resourceInjImp.add();
    }
}
```

###### @Value

注入普通类型属性

```java
@Service
public class ValueInjImp {
    @Value(value = "Hello ValueImp")
    private String name;

    public String getName() {
        System.out.println("ValueImp getName...");
        return name;
    }
}
```

##### 完全注解开发

（1）创建配置类，替代 xml 配置文件

```java
@Configuration //作为配置类,代替xml配置文件
@ComponentScan(basePackages = {"com.kali.annotation.fullAnnotation"})
public class ScannerCnf {
}
```



（2）编写测试类

```java
public class FullAnnotationTestMain {
    @Test
    public void fullAnnotationTestMain(){
    //加载配置类
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ScannerCnf.class);
        FullAnnotationTestService fullAnnotationTestService = ctx.getBean("fullAnnotationTestService", FullAnnotationTestService.class);
        System.out.println(fullAnnotationTestService);
        fullAnnotationTestService.add();
    }
}
```



# AOP

# JdbcTemplate

# 事务管理