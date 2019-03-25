package com.ht.springboot_mp.service.impl;

import com.ht.springboot_mp.entity.User;
import com.ht.springboot_mp.mapper.UserMapper;
import com.ht.springboot_mp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-03-22 -14:09
 */
@Service
@Transactional
public class UserviceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


//    查询全部
    @Override
    public List<User> selall() {
        return userMapper.selectList(null);
    }

//    登陆
    @Override
    public User sellogin(User user) {

        return  userMapper.login(user);
    }


//删除 @CacheEvict 应用到删除数据的方法上，调用方法时会从缓存中删除对应key的数据
    @Override
    @CacheEvict(value="users",key="'user_'+#id")
    public Integer del(Integer id) {
        return userMapper.deleteById(id);
    }

//   去修改   @Cacheable 应用到读取数据的方法上，先从缓存中读取，如果没有再从DB获取数据，然后把数据添加到缓存中
    @Override
    @Cacheable(value="users",key="'user_'+#id")
    public User toupd(Integer id) {
        System.out.println("进来了数据库查询");
        return userMapper.selectById(id);
    }

//添加  @CachePut 应用到写数据的方法上，如新增/修改方法，调用方法时会自动把相应的数据放入缓存
    @Override
    @CachePut(value = "users",key="'user_'+#user.id" )
    public User add(User user) {
//        因为不设值会报错  ，数据库id正常
        userMapper.add(user);
        return user;
    }

//    修改  @CachePut 应用到写数据的方法上，如新增/修改方法，调用方法时会自动把相应的数据放入缓存
    @Override
    @CachePut(value="users",key="'user_'+#result.id")
    public User upd(User user) {
        userMapper.upd(user);
        return user;
    }
}
