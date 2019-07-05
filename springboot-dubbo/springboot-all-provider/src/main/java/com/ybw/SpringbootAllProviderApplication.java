package com.ybw;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration // 启用dubbo注解
public class SpringbootAllProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAllProviderApplication.class, args);
    }
}
