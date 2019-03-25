package com.ht.springboot_mp.common;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-03-22 -20:58
 * 该类配置了可以访问static下所有文件夹
 * 并将文件上传配置在了本地文件上
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/upload/**").addResourceLocations("file:D:/temp-rainy/upload/");
    }
}
