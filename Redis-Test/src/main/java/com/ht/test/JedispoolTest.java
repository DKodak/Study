package com.ht.test;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-03-19 -9:58
 */
public class JedispoolTest {
    public static void main(String[] args) {
//        获取连接池配置
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
//            获取数据结果
               Set<String> keys= jedis.keys("*");
               for(String s:keys){
                   System.out.println(s);
               }

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
