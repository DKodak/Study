package com.ht.springboot_mp.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-03-22 -11:44
 */
@TableName("boot_mp")
@Data
public class User  implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;
    private String pwd;
    private String sex;
    private  String email;
    private Integer age;
    private String face;

}
