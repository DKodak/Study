package com.ht.springboot_power.utils;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-06-03 -20:35
 * @Email:2270301642@qq.com
 */
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisTokenUtils {
    private long timeout = 60 * 60;  //超时时间
    @Autowired
    private BaseRedisService baseRedisService;

    // 将token存入在redis
    public String getToken() {
        String token = "token" + System.currentTimeMillis();
        baseRedisService.setString(token, token, timeout);  //key: token value: token 时间
        return token;
    }

    public synchronized boolean findToken(String tokenKey) {  //从redis查询对应的token   防止没来得及删除 只有一个线程操作 其实redis已经可以防止了
        String token = (String) baseRedisService.getString(tokenKey);
        if (StringUtils.isEmpty(token)) { //要么被被人使用过了 要么没有对应token
            return false;
        }
        // token 获取成功后 删除对应tokenMapstoken
        baseRedisService.delKey(token);
        return true;  //保证每个接口对应的token只能访问一次，保证接口幂等性问题
    }

}
