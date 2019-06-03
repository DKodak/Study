package com.ht.springboot_shiro.service.impl;

import com.ht.springboot_shiro.dao.UserDao;
import com.ht.springboot_shiro.domain.User;
import com.ht.springboot_shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-06-03 -10:28
 * @Email:2270301642@qq.com
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User selectByname(String name) {
        return userDao.selectByname(name);
    }

    @Override
    public User selectByAll() {
        return userDao.selectByAll();
    }
}
