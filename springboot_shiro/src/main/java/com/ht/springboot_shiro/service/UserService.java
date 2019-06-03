package com.ht.springboot_shiro.service;

import com.ht.springboot_shiro.domain.User;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-06-03 -10:27
 * @Email:2270301642@qq.com
 */
public interface UserService {
    User selectByname(String name);

    User selectByAll();
}
