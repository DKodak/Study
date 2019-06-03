package com.ht.springboot_shiro.dao;

import com.ht.springboot_shiro.domain.User;
import org.apache.ibatis.annotations.Select;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-06-03 -10:29
 * @Email:2270301642@qq.com
 */
public interface UserDao {
    @Select("select id,name,pwd,perms from user where name=#{name}")
    User selectByname(String name);

    @Select("select id,name,pwd,perms from user")
    User selectByAll();
}
