package com.example.springdemo.ordelController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-02-21 -20:59
 */
@RestController
public class ordelconroller {
    @RequestMapping("ordel")
    public String ordel(){
        return "ordel";
    }
}
