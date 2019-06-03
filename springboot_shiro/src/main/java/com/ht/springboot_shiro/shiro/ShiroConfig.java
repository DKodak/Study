package com.ht.springboot_shiro.shiro;

import java.util.LinkedHashMap;
import java.util.Map;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @company 宏图
 * @User Kodak
 * @create 2019-06-02 -20:09
 * @Email:2270301642@qq.com
 * DefaultWebSecurityManager 是org.apache.shiro.spring.web.ShiroFilterFactoryBean;下的包
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Configuration //配置类
public class ShiroConfig {
    /**
     * 创建ShiroFiterFactoryBean
     */
    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //添加Shiro内置过滤器
        /**
         * Shiro内置过滤器，可以实现权限相关的拦截器
         *    常用的过滤器：
         *       anon: 无需认证（登录）可以访问
         *       authc: 必须认证才可以访问
         *       user: 如果使用rememberMe的功能可以直接访问
         *       perms： 该资源必须得到资源权限才可以访问
         *       role: 该资源必须得到角色权限才可以访问
         */
        Map<String,String> filterMap = new LinkedHashMap<String,String>();
        //前为controller的控制器访问路径  后为过滤器的协议
//		filterMap.put("/add", "authc");
//		filterMap.put("/upd", "authc");
        //表示文件夹下
//		filterMap.put("/user/","authc");
        //配置无需登录验证的
        filterMap.put("/testThymeleaf","anon");
        filterMap.put("/login","anon");

        //授权过滤器
        filterMap.put("/add","perms[user:add]");
        filterMap.put("/upd","perms[user:upd]");

        //全部拦截
		filterMap.put("/*","authc");


		//设置登录跳转url
		shiroFilterFactoryBean.setLoginUrl("/tologin");
        //设置未授权提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);


        return shiroFilterFactoryBean;
    }


    /**
     * 创建DefaultwebSecurityManager
     *                                                      Qualifier得到下面的@bean的对象
     */
        @Bean(name = "securityManager")
        public DefaultWebSecurityManager getDefaultSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
           DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
            //关联realm
            securityManager.setRealm(userRealm);
            return securityManager;
        }


    /**
     * 创建Realm
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }

    /**
     * 配置ShiroDialect 用于thymeleaf利用shiro标签配合使用
     */
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
