package com.spring20201220.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.spring20201220")
@EnableAspectJAutoProxy
public class AppConfig {
    @Bean
    public View jsonTemplate() {
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        view.setPrettyPrint(true);
        return view;
    }
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
//    @Bean
//    public FilterRegistrationBean<CheckReqFilter> filterRegistrationBean() {
//        FilterRegistrationBean < CheckReqFilter > registrationBean = new FilterRegistrationBean();
//        CheckReqFilter checkReqFilter = new CheckReqFilter();
//
//        registrationBean.setFilter(checkReqFilter);
//        registrationBean.addUrlPatterns("/*");
//        registrationBean.setOrder(2); //set precedence
//        return registrationBean;
//    }
//    @Bean
//    public ViewResolver viewResolver() {
//        return new BeanNameViewResolver();
//    }
}
