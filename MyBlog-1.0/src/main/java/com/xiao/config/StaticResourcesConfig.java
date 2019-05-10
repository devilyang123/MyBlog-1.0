package com.xiao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 静态资源方行配置类
 * @Auther: 笑笑
 * @Date: 20:56 2018/8/29
 */
@Configuration
//@EnableWebMvc 此注解表示全面接管srpingMVC，srpingboot自动配置全都忽略
public class StaticResourcesConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

    }
}
