package com.ht.springboot_power;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan(basePackages = { "com.ht.springboot_power.mapper" })
@ServletComponentScan
public class SpringbootPowerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootPowerApplication.class, args);
    }

}
