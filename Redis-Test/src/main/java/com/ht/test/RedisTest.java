package com.ht.test;


import redis.clients.jedis.Jedis;
import sun.applet.Main;

import java.util.Set;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-03-06 -21:00
 */
public class RedisTest {
    private  static Jedis jedis=null;

//    public static void main(String[] args) {
//        //连接本地的 Redis 服务
//        Jedis jedistest = new Jedis("127.0.0.1",6379);


////      jedis.select(1);
//        System.out.println("Connection to server sucessfully");
//        //查看服务是否运行
//        System.out.println("Server is running: "+jedis.ping());
//    }

    public static void main(String[] args) {
        //创建redis对象
         jedis=new Jedis("127.0.0.1",6379);
        //查看服务是否运行
        System.out.println(jedis.ping()+"  ");
//         连接jedis
        jedis.connect();

           Set<String> str= jedis.keys("*");
           for (String s:str){
               System.out.println(s);
           }




        jedis.disconnect();
    }

}
