package com.example.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan("com.example.springdemo.Controller")//使所有Controller包下的控制器都可以使用
                                                    //ComponentScan缺点当控制多并且不在同一个包的时候麻烦
//
//@ComponentScan(basePackages = {"com.example.springdemo.Controller","com.example.springdemo.ordelController"})
public class SpringdemoApplication {

    public static void main(String[] args) {
    //整个程序的入口
        //@ComponentScan(basePackages = {"com.example.springdemo.Controller","com.example.springdemo.ordelController"})扫包麻烦
        //@SpringBootApplication等同于@EnableAutoConfiguration+@ComponentScan
        //包等同于子包

        SpringApplication.run(SpringdemoApplication.class, args);
    }

}
