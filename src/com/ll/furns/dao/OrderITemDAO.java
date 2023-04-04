package com.ll.furns.dao;

import com.ll.furns.entity.OrderItem;

import java.util.List;

public interface OrderITemDAO {
    public int saveOrderItem(OrderItem orderItem);
    public List<OrderItem> queryOrderItem();
    public List<OrderItem> queryOrderItemById(String id);

}
