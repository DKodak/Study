package com.ht.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @company 宏图
 * @User Kodak
 * @create 2018-12-04 -16:49
 */
public class SqlSessionFactoryUtil {

    private  static SqlSessionFactory sqlSessionFactory;

    public    static SqlSessionFactory getSqlSessionFactory(){
        if(sqlSessionFactory==null){
            InputStream inputStream=null;
            try{
//                inputStream= Resources.getResourceAsStream("classpath:mybiats/mybaits-cfg.xml");
                 inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("mybaits/mybaits-cfg.xml");
                sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return sqlSessionFactory;
    }

    public static SqlSession openSession(){
        return getSqlSessionFactory().openSession();
    }
}
