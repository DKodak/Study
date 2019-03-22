package com.ht.springboot_vue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@MapperScan(basePackages = {"com.ht.springboot_vue.dao"})
@EnableAsync
public class SpringbootVueApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootVueApplication.class, args);
    }

//    @Bean
//    MultipartConfigElement multipartConfigElement(){
//        MultipartConfigFactory factory=new MultipartConfigFactory();
//        factory.setLocation("D:\\temp-rainy\\upload\\");
//        return factory.createMultipartConfig();
//    }

}
