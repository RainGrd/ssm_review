package com.bdqn.config;

import com.bdqn.interceptor.PrivilegeInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/8/23 7:32
 * FileName: WebConfig
 * Description: 配置拦截器
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     * 配置视图解析器
     * @return org.springframework.web.servlet.ViewResolver
     */
    @Bean
    public ViewResolver ViewResolver(){
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        /*配置前缀*/
        internalResourceViewResolver.setPrefix("/WEB-INF/pages");
        /*配置文件类型*/
        internalResourceViewResolver.setSuffix(".jsp");
        /*设置*/
        internalResourceViewResolver.setExposeContextBeansAsAttributes(true);
        return internalResourceViewResolver;
    }
    /**
     * 注解拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 是配置需要拦截的方法，如果遇到拦截不同的Controller，
        // 我们可以使用不同的配置，比如：/user/* 在这里是可以配置多个拦截器的。
        registry.addInterceptor(new PrivilegeInterceptor()).addPathPatterns("/*");
    }
    /*对于静态资源的处理*/

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
