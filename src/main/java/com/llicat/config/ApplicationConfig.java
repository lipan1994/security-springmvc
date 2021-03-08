package com.llicat.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * 配置spring容器(spring-service.xml、spring-dao.xml)
 * @author: lipan
 * @date: 2021/2/16 20:17
 */
@Configuration
@ComponentScan(basePackages = "com.llicat")
public class ApplicationConfig {


}
