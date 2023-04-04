package com.ll.furns.service;

import com.ll.furns.entity.Cart;
import com.ll.furns.entity.OrderItem;

import java.util.List;

public interface OrderItemService {
    public List<OrderItem> queryOrderItem();
    public List<OrderItem> queryOrderItemById(String id);
}
