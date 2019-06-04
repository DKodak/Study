package com.ht.springboot_power.mapper;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-06-03 -20:36
 * @Email:2270301642@qq.com
 */
import org.apache.ibatis.annotations.Insert;

import com.ht.springboot_power.entity.OrderEntity;

public interface OrderMapper {
    @Insert("insert order_info values (null,#{orderName},#{orderDes})")
    public int addOrder(OrderEntity OrderEntity);
}
