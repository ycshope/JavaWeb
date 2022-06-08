package com.kali.aop.aspectj.fullannotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


//创建配置类,不需要创建xml配置文件
@Configuration //作为配置类,代替xml配置文件
@ComponentScan(basePackages = {"com.kali.aop.aspectj.fullannotation"})
@EnableAspectJAutoProxy(proxyTargetClass = true) //相当于 <aop:before method="before" pointcut-ref="p"></aop:before>
public class CnfScanner {
}
