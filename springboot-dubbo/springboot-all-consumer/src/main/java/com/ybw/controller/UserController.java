package com.ybw.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ybw.pojo.User;
import com.ybw.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ybw
 * @createDate 2018/9/22
 **/
@Controller
public class UserController {

    @Reference
    private UserService userService;


    @RequestMapping(value = {"/index","/"})
    public String index(Model model, @RequestParam(required = false) Integer curPage){
        // 每页展示10条数据
        int pageSize = 10;
        // 计算总数
        int totalCount = userService.getTotalCount();
        // 计算分页
        int pageCount = totalCount / pageSize;
        // 有可能有余数
        int left = totalCount % pageSize;
        if(left>0){
            pageCount = pageCount+1;
        }

        // 分页查询
        if(null == curPage){
            curPage = 1;
        }

        if(curPage < 1){
            curPage = 1;
        }

        if(curPage > pageCount){
            curPage = pageCount;
        }
        // 开始位置
        int startRow = (curPage - 1) * pageSize;
        Map<String,Object> pageMap = new ConcurrentHashMap<>();
        pageMap.put("startRow",startRow);
        pageMap.put("pageSize",pageSize);

        List<User> userList = userService.getUserByPage(pageMap);


        // 保存数据
        model.addAttribute("userList",userList);
        model.addAttribute("curPage",curPage);
        model.addAttribute("pageCount",pageCount);
        // 跳转到模板页面
        return "index";
    }

    /**
     * 去添加页面
     * @return
     */
    @RequestMapping("/add")
    public String toAdd(){
        return "add";
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping("/addUser")
    public String doAdd(User user){

        // 添加用户
        int result = userService.addUser(user);

        return "redirect:/";
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public String doDelete(Integer id){

        // 删除用户
        int result = userService.delete(id);

        return "redirect:/";
    }

    /**
     * 去修改页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toUpdate")
    public String toUpdate(Integer id,Model model){

        // 查询用户
        User user = userService.getUserById(id);

        model.addAttribute("user",user);

        return "update";
    }
    /**
     * 修改用户
     * @param user
     * @return
     */
    @RequestMapping("/doUpdate")
    public String doUpdate(User user){

        // 修改用户
        int result = userService.update(user);

        return "redirect:/";
    }
}
