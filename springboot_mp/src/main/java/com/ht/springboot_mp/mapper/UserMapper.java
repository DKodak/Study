package com.ht.springboot_mp.mapper;

import com.baomidou.mybatisplus.core.injector.methods.SelectList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ht.springboot_mp.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-03-22 -11:43
 */
@Mapper
public interface UserMapper  extends BaseMapper<User> {


    @Select("select * from boot_mp where name=#{name} and pwd=#{pwd}")
    User login(User user);

    @Insert("insert into boot_mp values(null,#{name},#{pwd},#{age},#{sex},#{face},#{email})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")  //注解返回id
    Integer add(User user);

    @Update("update boot_mp set name=#{name},pwd=#{pwd},age=#{age},sex=#{sex},face=#{face},email=#{email} where id=#{id}")
    Integer upd(User user);

}
