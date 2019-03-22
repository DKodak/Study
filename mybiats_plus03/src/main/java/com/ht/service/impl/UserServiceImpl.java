package com.ht.service.impl;

import com.ht.beans.User;
import com.ht.mapper.UserMapper;
import com.ht.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kodak
 * @since 2019-03-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    //不用再进行mapper的注入
    /**
     * UserServiceImpl继承了ServiceImpl
     * 1 在ServiceImpl中已经完成了mapper对象的注入 直接在UserServiceImpl中进行使用
     *2 在ServiceImpl中也帮我们提供了常用的crud方法，基本的一些crud方法在service中不需要自己定义
     *
     * */
    @Autowired
    private UserService userService;

//    public String login(){
//        userService.select();
//        return null;
//    }
}
