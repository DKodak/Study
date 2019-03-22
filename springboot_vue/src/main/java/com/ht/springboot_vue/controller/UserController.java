package com.ht.springboot_vue.controller;

import com.alibaba.fastjson.JSONObject;
import com.ht.springboot_vue.bean.User;
import com.ht.springboot_vue.dao.UserDao;
import com.ht.springboot_vue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-03-11 -15:20
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;



    @RequestMapping("/list")
    @ResponseBody
    public ModelAndView list(){
        List<User> list=userService.alluser();
        ModelAndView mv=new ModelAndView();
        mv.addObject("list",list);
        mv.setViewName("index2");
        return  mv;
    }


    @RequestMapping("/jsonlist")
    @ResponseBody
    public List<User> jsonlist(){
        JSONObject json=new JSONObject();
        List<User> list=userService.alluser();
        json.put("list",list);
        System.out.println(json);
        return list;
    }

    @ResponseBody
    @RequestMapping("/del")
    public String del(Integer id){
        System.out.println(id+"                    删除");

        if(id!=null){
            userService.del(id);
        }
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("msg","删除成功");

//        return "redirect:list";
        return jsonObject.toString();
    }




    @RequestMapping("/toupd")
    public String toupd(Integer id,User user){
        if (id!=null){
            JSONObject jsonObject=new JSONObject();
          User u=  userService.toupd(id);
          jsonObject.put("u",u);
          return jsonObject.toString();


        }
        return null;
    }


    @RequestMapping("/add")
//    @ResponseBody
    public  ModelAndView add(User user, MultipartFile faces, HttpServletRequest request, BindingResult bindingResult) throws IOException {
//        System.out.println("进来了................");
//        System.out.println(faces+"add.....");
        String img="";
        if(faces.getOriginalFilename()!=null&&!faces.getOriginalFilename().equals("")){//上传了文件在进来
            //处理图片名称
            String picName= UUID.randomUUID().toString()+faces.getOriginalFilename().substring(faces.getOriginalFilename().lastIndexOf("."));
            String path="D:/temp-rainy/"; //设置存储位置
            //日期格式化 sim.format日期转字符串    sim.parse字符串装日期
            SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
            String data=sim.format(new Date());
            //整体路径
            String dirName="/upload/"+data;
            File dirFile = new File(path+dirName);
            if(!dirFile.exists()){  //创建文件夹
                dirFile.mkdirs();
            }
            File targetFile = new File(path+dirName,picName);
            faces.transferTo(targetFile);  // 保存文件


             img=dirName+"/"+picName;

        }
        user.setFace(img);
        ModelAndView mv=new ModelAndView();
        if(user.getId()==null){
            userService.add(user);
            mv.setViewName("redirect:list");
        }else {
            userService.upd(user);
            mv.setViewName("redirect:list");
        }
        return mv;

    }

}
