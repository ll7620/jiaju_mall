package com.ll.furns.dao.impl;

import com.ll.furns.dao.BasicDAO;
import com.ll.furns.dao.OrderDAO;
import com.ll.furns.entity.Order;
import com.ll.furns.entity.OrderItem;

import java.util.List;

public class OrderDAOImpl extends BasicDAO<Order> implements OrderDAO {
    @Override
    public int saveOrder(Order order) {
        String sql = "INSERT INTO `order`(`id`,`create_time`,`price`,`status`,`member_id`) VALUES(?,?,?,?,?) ";
        return update(sql,order.getId(),order.getCreatTime(),order.getPrice(),order.getStatus(),order.getMemberId());
    }

    @Override
    public Order queryOrderById(int id) {
        String sql ="select `id`,`create_time`,`price`,`status`,`member_id` from `order` where `id` =  ? ";
        return querySingle(sql, Order.class,id);
    }

    @Override
    public List<Order> queryOrders() {
        String sql ="select `id`,`create_time` creatTime,`price`,`status`,`member_id` from `order`";
        return queryMulti(sql, Order.class);

    }
}
