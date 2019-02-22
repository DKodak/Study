package com.example.springdemo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-02-21 -20:35
 */
@RestController

public class indexController {
    @RequestMapping("/index")
    public String hello(){

        return "springboot2.0  index";
    }
}
