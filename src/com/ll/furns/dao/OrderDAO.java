package com.ll.furns.dao;

import com.ll.furns.entity.Order;
import com.ll.furns.entity.OrderItem;

import java.util.List;

public interface OrderDAO {
    public int saveOrder(Order order);
    public Order queryOrderById(int id);
    public List<Order> queryOrders();
}
