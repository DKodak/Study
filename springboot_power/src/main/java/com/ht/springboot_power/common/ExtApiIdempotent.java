package com.ht.springboot_power.common;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-06-03 -20:32
 * @Email:2270301642@qq.com
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExtApiIdempotent {
    String value();
}
