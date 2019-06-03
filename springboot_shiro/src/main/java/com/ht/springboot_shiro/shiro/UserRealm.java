package com.ht.springboot_shiro.shiro;

import com.ht.springboot_shiro.domain.User;
import com.ht.springboot_shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.servlet.ShiroHttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-06-02 -20:12
 * @Email:2270301642@qq.com
 */
//继承shiro类
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userServicel;

    /**
     * 执行授权逻辑
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行授权逻辑");
        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取当前登录的用户得到认证中返回的user对象并授权
        Subject subject= SecurityUtils.getSubject();
        User user= (User) subject.getPrincipal();
        //添加资源的授权字符串
        info.addStringPermission(user.getPerms());
        return info;
    }


    /**
     * 执行认证逻辑
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        System.out.println("执行认证逻辑"+token+"     ");

       UsernamePasswordToken MyToken=(UsernamePasswordToken)token;
        //1判断用户名
      User user= userServicel.selectByname(MyToken.getUsername());

       if (user==null){
           return  null;//shiro底层会抛出UnknownAccountException异常然后controller会捕获
       }

        return new SimpleAuthenticationInfo(user,user.getPwd(),"");
    }
}
