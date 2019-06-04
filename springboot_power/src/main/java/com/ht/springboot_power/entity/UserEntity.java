package com.ht.springboot_power.entity;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-06-03 -20:36
 * @Email:2270301642@qq.com
 */
public class UserEntity {

    private Long id;
    private String userName;
    private String password;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "UserEntity [id=" + id + ", userName=" + userName + ", password=" + password + "]";
    }

}
