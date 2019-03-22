package com.ht.springboot_vue.dao;

import com.ht.springboot_vue.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-03-11 -15:18
 */

public interface UserDao {
    @Select("select * from test")
    public List<User> alluser();


    @Select("select * from test where id=#{id}")
    User toupd(Integer id);

    @Insert("insert into test value(null,#{name},#{age},#{email},#{face})")
    boolean add(User user);

    @Update("update test set name=#{name},age=#{age},email=#{email},face=#{face} where id=#{id}")
    boolean upd(User user);

    @Select("delete from test where id=#{id}")
    String  del(Integer id);
}
