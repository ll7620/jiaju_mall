package com.ll.furns.service;

import com.ll.furns.entity.Cart;
import com.ll.furns.entity.Order;

import java.util.List;

public interface OrderService {
    public String saveOrder(Cart cart,int member);
    public Order queryOrderById(int id);
    public List<Order> queryOrders();
}
