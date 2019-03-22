package com.ht.springboot_vue.service.impl;

import com.ht.springboot_vue.bean.User;
import com.ht.springboot_vue.dao.UserDao;
import com.ht.springboot_vue.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-03-11 -15:20
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public List<User> alluser() {
        return userDao.alluser();
    }

    @Override
    public User toupd(Integer id) {
        return userDao.toupd(id);
    }

    @Override
    public String del(Integer id) {
        return userDao.del(id);
    }

    @Override
    public boolean add(User user) {
        return userDao.add(user);
    }

    @Override
    public boolean upd(User user) {
        return userDao.upd(user);
    }
}
