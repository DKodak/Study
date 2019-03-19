package com.ht.entity;

import lombok.Data;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-03-19 -10:07
 */

//@Data  //使用lombok插件自动生成get() set() tostring()方法
public class User {
    private Integer id;
    private Integer age;
    private String name;
    private String email;

    public User() {
    }

    public User(Integer id, Integer age, String name, String email) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
