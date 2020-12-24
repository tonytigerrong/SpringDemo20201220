package com.spring20201220.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.io.IOException;

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

    @Bean
    public  PropertyPlaceholderConfigurer ppc() throws IOException {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocations(new ClassPathResource("properties/property.properties"));
        ppc.setIgnoreUnresolvablePlaceholders(true);
        return ppc;
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
