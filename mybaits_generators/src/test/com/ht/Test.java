package com.ht;

import com.ht.mapper.UsersMapper;
import com.ht.pojo.Users;
import com.ht.pojo.UsersExample;
import com.ht.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;

import java.util.List;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-05-22 -19:04
 */
public class Test {
    private SqlSession sqlSession=null;
    private UsersMapper usersMapper;

    @Before
    public void setUp() throws Exception {
        sqlSession= SqlSessionFactoryUtil.openSession();
        usersMapper=sqlSession.getMapper(UsersMapper.class);


    }

    @After
    public void tearDown() throws Exception {
        sqlSession.close();
    }


    @org.junit.Test
    public void  testSelectbyid(){
        //根据id查询单个
       Users users= usersMapper.selectByPrimaryKey(1);
        System.out.println(users);
    }
    @org.junit.Test
    public  void  testInsert(){
        //添加
        Users users=new Users();
        users.setAihao("asdas");
        users.setBook("mybaits逆向生成");
        users.setSex("男");
        users.setUname("kodak");
        users.setPwd("123123");
        usersMapper.insertSelective(users);
        sqlSession.commit();
        System.out.println("添加成功");
    }

    @org.junit.Test
    public void  testDeletebyid(){
        //根据id删除单个
     int result= usersMapper.deleteByPrimaryKey(17);
        sqlSession.commit();
        System.out.println(result);
    }

    @org.junit.Test
    public  void  testUpdatebyid(){
        Users users=new Users();
        users.setPwd("522");
        users.setUname("522情人节快乐");
        users.setId(14);
        //注意！！    只有当设置的才会被修改
        usersMapper.updateByPrimaryKeySelective(users);
        sqlSession.commit();
        System.out.println("修改成功");
    }

    @org.junit.Test
    public void TestUserExample(){
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria UsercCriteria=usersExample.createCriteria();
        //使用Example后缀的对象需要可以有自带的动态sql拼接
        //使用模糊查询查找
        UsercCriteria.andAihaoLike("%小说%");
        List<Users> usersList=usersMapper.selectByExample(usersExample);
        System.out.println(usersList);
    }

}
