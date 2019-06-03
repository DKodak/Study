package com.ht.springboot_shiro.domain;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-06-03 -10:26
 * @Email:2270301642@qq.com
 */
public class User {
    private Integer id;
    private String name;
    private String pwd;
    private String perms;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }
}
