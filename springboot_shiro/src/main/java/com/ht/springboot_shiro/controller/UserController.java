package com.ht.springboot_shiro.controller;

import com.ht.springboot_shiro.domain.User;
import com.ht.springboot_shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-06-02 -20:02
 * @Email:2270301642@qq.com
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("testThymeleaf")
    public String testThymeleaf(Model model){
        return "hello";
    }

    @RequestMapping("add")
    public String add(){
        return "user/add";
    }

    @RequestMapping("upd")
    public String update(){
        return "user/update";
    }

    @RequestMapping("tologin")
    public String tologin(){
        return "login";
    }

    @RequestMapping("noAuth")
    public String noAuth(){
        return "noAuth";
    }


    @RequestMapping("/login")
    public String login(String name, String pwd, Model model, HttpSession session){
        System.out.println(name+"    "+pwd);
        //获取subject
        Subject subject= SecurityUtils.getSubject();
        //封装用户数据
        UsernamePasswordToken token=new UsernamePasswordToken(name,pwd);
        //执行登录方法
        try {
            subject.login(token);
           User user=(User) subject.getPrincipal();
           session.setAttribute("user",user);
            System.out.println(user.getName()+user.getPwd()+"session");
//            System.out.println("shiro中的session");
//            System.out.println("用户IP地址"+session.getHost()+"   用户shiroID"+session.getId());
//            session.touch();

            return "hello";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "login";
        }


    }

    //移除session
    @RequestMapping("/loginout")
    public String loginout(HttpSession session){
        session.removeAttribute("user");
        return "hello";
    }
}
