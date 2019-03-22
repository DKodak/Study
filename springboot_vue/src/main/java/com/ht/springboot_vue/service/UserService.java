package com.ht.springboot_vue.service;

import com.ht.springboot_vue.bean.User;

import java.util.List;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-03-11 -15:19
 */
public interface UserService {
    public List<User> alluser();

    User toupd(Integer id);

    String  del(Integer id);

    boolean add(User user);

    boolean upd(User user);
}
