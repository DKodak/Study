package com.ht.springboot_vue;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 资源映射路径
 */
@Component  //把组件添加到springboot中
public class MyWebAppConfigurer implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
                                                                                    //这里需显示最终保存的路径
        registry.addResourceHandler("/upload/**").addResourceLocations("file:D:/temp-rainy/upload/");

    }
}
