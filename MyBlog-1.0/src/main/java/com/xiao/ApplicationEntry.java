package com.xiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Description 程序入口类
 * @Auther: 笑笑
 * @Date: 20:33 2018/9/23
 */
@SpringBootApplication
@EnableScheduling
public class ApplicationEntry extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ApplicationEntry.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationEntry.class, args);
    }
}



