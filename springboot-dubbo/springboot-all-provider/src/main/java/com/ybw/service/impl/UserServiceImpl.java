package com.ybw.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ybw.mapper.UserMapper;
import com.ybw.pojo.User;
import com.ybw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author ybw
 * @createDate 2018/9/22
 **/
@Component
@Service //dubbo的service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public List<User> getUserByPage(Map<String, Object> pageMap) {
        return userMapper.getUserByPage(pageMap);
    }

    @Override
    public int getTotalCount() {
        // 设置key的序列化方式：采用字符串可读性好
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        Integer totalRow = (Integer) redisTemplate.opsForValue().get("totalRow");
        if(null == totalRow ){

            // 缓存同步,防止缓存穿透
            synchronized (this){
                totalRow = (Integer)redisTemplate.opsForValue().get("totalRow");

                if(null == totalRow){
                    totalRow = userMapper.getUserTotalCount();
                    redisTemplate.opsForValue().set("totalRow",totalRow);
                }
            }
        }
        return totalRow;
    }

    @Override
    public int addUser(User user) {
        // 设置key的序列化方式：采用字符串可读性好
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        int result = userMapper.insertSelective(user);
        if(result>0){
            // 更新缓存
            int totalRow = userMapper.getUserTotalCount();
            redisTemplate.opsForValue().set("totalRow",totalRow);
        }
        return result;
    }

    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int delete(Integer id) {
        // 设置key的序列化方式：采用字符串可读性好
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        int result = userMapper.deleteByPrimaryKey(id);
        if(result>0){
            // 更新缓存
            int totalRow = userMapper.getUserTotalCount();
            redisTemplate.opsForValue().set("totalRow",totalRow);
        }
        return result;
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
