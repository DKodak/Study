package com.ht.springboot_mp.service;

import com.ht.springboot_mp.entity.User;

import java.util.List;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-03-22 -14:08
 */
public interface UserService {
//查询全部
    public List<User> selall();

    //登陆查询
    public User sellogin(User user);
//删除
    public Integer del(Integer id);
    //去修改
    public User toupd(Integer id);

    User add(User user);

    User upd(User user);
}
