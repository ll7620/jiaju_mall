package com.ll.furns.dao.impl;

import com.ll.furns.dao.BasicDAO;
import com.ll.furns.dao.OrderITemDAO;
import com.ll.furns.entity.Furn;
import com.ll.furns.entity.OrderItem;

import java.util.List;

public class OrderITemDAOImpl extends BasicDAO<OrderItem> implements OrderITemDAO {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "INSERT INTO `order_item`(`id`,`name`,`price`,`count`,`total_price`,`order_id`)VALUES(NULL,?,?,?,?,?) ";
        return update(sql, orderItem.getName(), orderItem.getPrice(), orderItem.getCount(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> queryOrderItem() {
        String sql ="select  `id`,`name`,`price`,`count`,`total_price`,`order_id` from order_item ";
        return queryMulti(sql, OrderItem.class);
    }

    @Override
    public List<OrderItem> queryOrderItemById(String id) {
        String sql ="select  `id`,`name`,`price`,`count`,`total_price` totalPrice,`order_id` orderId from order_item where order_id = ? ";
        return queryMulti(sql, OrderItem.class,id);
    }
}
