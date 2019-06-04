package com.ht.springboot_power.mapper;

import com.ht.springboot_power.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-06-03 -20:36
 * @Email:2270301642@qq.com
 */
public interface UserMapper {

    @Select(" SELECT  * FROM user_info where userName=#{userName} and password=#{password}")
    public UserEntity login(UserEntity userEntity);

    @Insert("insert user_info values (null,#{userName},#{password})")
    public int insertUser(UserEntity userEntity);
}
