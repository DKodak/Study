package com.example.springdemo.Controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-02-20 -21:04
 */
@RestController

public class hellcontroller {
    @RequestMapping("/hello")
    public String hello(){

        return "springboot2.0";
    }
}
