package com.ht.springboot_power.controller;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-06-03 -20:33
 * @Email:2270301642@qq.com
 */
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.ht.springboot_power.common.ExtApiIdempotent;
import com.ht.springboot_power.entity.OrderEntity;
import com.ht.springboot_power.mapper.OrderMapper;
import com.ht.springboot_power.utils.ConstantUtils;
import com.ht.springboot_power.utils.RedisTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class OrderPageController {
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private RedisTokenUtils redisTokenUtils;

    @RequestMapping("/indexPage")
    public String indexPage(HttpServletRequest req) {
        req.setAttribute("token",redisTokenUtils.getToken());
        return "indexPage";
    }

    @RequestMapping("/addOrderPage")
    @ExtApiIdempotent(value = ConstantUtils.EXTAPIFROM)
    public String addOrder(OrderEntity orderEntity) {
        int addOrder = orderMapper.addOrder(orderEntity);
        return addOrder > 0 ? "success" : "fail";
    }

}
