package com.ht.springboot_mp.controller;

import com.alibaba.fastjson.JSONObject;
import com.ht.springboot_mp.entity.User;
import com.ht.springboot_mp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-03-22 -14:10
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;



//返回首页
    @RequestMapping("/list")
    @ResponseBody
    public ModelAndView list(){
        List<User> list=userService.selall();
        ModelAndView mv=new ModelAndView();
        mv.addObject("list",list);
        mv.setViewName("index");
        return  mv;
    }

//    查询全部
    @RequestMapping("/all")
    @ResponseBody
    public JSONObject all(){
        JSONObject json=new JSONObject();
        List<User> list=userService.selall();
        json.put("list",list);

        return json;
    }

    //去登陆
    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }

//登陆
    @RequestMapping("/logins")
    public String login(User user){
           user= userService.sellogin(user);
           if(user!=null){
               return "index";
           }
           return null;

    }



    @ResponseBody
    @RequestMapping("/del")
    public String del(Integer id){

        if(id!=null){
            userService.del(id);
        }
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("msg","删除成功");

//        return "redirect:list";
        return jsonObject.toString();
    }


    @RequestMapping("/toupd")
    @ResponseBody
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

        if(img==null||img.equals("")){
            user.setFace(user.getFace());
        }else {
            user.setFace(img);
        }

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
