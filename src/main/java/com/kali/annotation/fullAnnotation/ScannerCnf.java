package com.kali.annotation.fullAnnotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //作为配置类,代替xml配置文件
@ComponentScan(basePackages = {"com.kali.annotation.fullAnnotation"})
public class ScannerCnf {
}
