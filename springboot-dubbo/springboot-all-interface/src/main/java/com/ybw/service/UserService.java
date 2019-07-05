package com.ybw.service;

import com.ybw.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author ybw
 * @createDate 2018/9/22
 **/
public interface UserService {

    /**
     * 分页查询
     * @param pageMap
     * @return
     */
    List<User> getUserByPage(Map<String,Object> pageMap);

    /**
     * 查询总数
     * @return
     */
    int getTotalCount();

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User getUserById(Integer id);
}
