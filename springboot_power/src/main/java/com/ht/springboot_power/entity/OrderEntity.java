package com.ht.springboot_power.entity;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-06-03 -20:35
 * @Email:2270301642@qq.com
 */
public class OrderEntity {

    private int id;
    private String orderName;
    private String orderDes;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderDes() {
        return orderDes;
    }

    public void setOrderDes(String orderDes) {
        this.orderDes = orderDes;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", orderName='" + orderName + '\'' +
                ", orderDes='" + orderDes + '\'' +
                '}';
    }
}
