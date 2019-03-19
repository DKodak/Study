package com.ht.test;

import com.ht.entity.User;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-03-19 -10:07
 */
public class CaseTest {
    public static void main(String[] args) {
       // 获取连接池配置
        JedisPoolConfig config=new JedisPoolConfig();
//        设置连接池最大链接数
        config.setMaxTotal(50);
//        设置连接池最大空闲数
        config.setMaxIdle(10);
        //获得连接池
        JedisPool jedisPool=new JedisPool(config,"127.0.0.1",6379);
        //获取核心对象
        Jedis jedis=null;
        try {
//            通过连接池连接redis缓存数据库
            jedis=jedisPool.getResource();

//            创建一个user对象
            User u=new User(1,20,"zhangsan","2270301642@qq.com");

//            创建map并将user对象放进map中
            Map map=new HashMap();
            map.put("id",u.getId()+"");
            map.put("name",u.getName());
            map.put("age",u.getAge()+"");
            map.put("email",u.getEmail());
        //将map封装进redis
            jedis.hmset("usermap",map);
            Map resultmap=jedis.hgetAll("usermap");
            System.out.println("查询返回的数据是:"+resultmap);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
//            关闭redis连接
            if(jedis!=null){
                jedis.close();
                System.out.println("redis连接已关闭");
            }
            //关闭连接池
            if(jedisPool!=null){
                jedisPool.close();
                System.out.println("连接池已关闭");
            }
        }
    }
}
