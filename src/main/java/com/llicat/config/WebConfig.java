package com.llicat.config;

import com.llicat.interceptor.SimpleAuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.lang.reflect.Type;

/**
 * @author: lipan
 * @date: 2021/2/16 20:31
 * WebMvcConfigurer 此接口用来增加一些自定义的handler、interceptor、ViewReslover等，多用于springboot下的客户化
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.llicat")
public class WebConfig implements WebMvcConfigurer {


    @Autowired
    SimpleAuthenticationInterceptor simpleAuthenticationInterceptor;

    //添加视图解析器
    @Bean
    public InternalResourceViewResolver resourceViewResolver(){

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(simpleAuthenticationInterceptor).addPathPatterns("/r/**");
    }
}
