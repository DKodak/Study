package com.ht.springboot_vue.controller;

import com.alibaba.fastjson.JSONObject;
import com.ht.springboot_vue.bean.User;
import com.ht.springboot_vue.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-03-13 -8:19
 */
@Controller
@RequestMapping("/users")
public class JumpController {
    @Resource
    private UserService userService;


    @RequestMapping("/all")
    @ResponseBody
    public  JSONObject  all(){
        JSONObject json=new JSONObject();
        List<User> list=userService.alluser();
        json.put("list",list);
        System.out.println(json);
        return json;
    }
}
