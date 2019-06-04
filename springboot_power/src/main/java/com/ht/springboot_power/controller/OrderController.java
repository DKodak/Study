package com.ht.springboot_power.controller;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-06-03 -20:33
 * @Email:2270301642@qq.com
 */
import javax.servlet.http.HttpServletRequest;

import com.ht.springboot_power.common.ExtApiIdempotent;
import com.ht.springboot_power.entity.OrderEntity;
import com.ht.springboot_power.mapper.OrderMapper;
import com.ht.springboot_power.utils.ConstantUtils;
import com.ht.springboot_power.utils.RedisTokenUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RedisTokenUtils redisTokenUtils;

    // 从redis中获取Token
    @RequestMapping("/redisToken")
    public String RedisToken() {
        return redisTokenUtils.getToken();
    }

    // 验证Token
    @RequestMapping(value = "/addOrderExtApiIdempotent", produces = "application/json; charset=utf-8")
    @ExtApiIdempotent(value = ConstantUtils.EXTAPIHEAD)
    public String addOrderExtApiIdempotent(@RequestBody OrderEntity orderEntity, HttpServletRequest request) {
        int result = orderMapper.addOrder(orderEntity);
        return result > 0 ? "添加成功" : "添加失败" + "";
    }
}
