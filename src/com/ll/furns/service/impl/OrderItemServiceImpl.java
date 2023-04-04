package com.ll.furns.service.impl;

import com.ll.furns.dao.OrderITemDAO;
import com.ll.furns.dao.impl.OrderITemDAOImpl;
import com.ll.furns.entity.Furn;
import com.ll.furns.entity.OrderItem;
import com.ll.furns.service.OrderItemService;

import java.util.List;

public class OrderItemServiceImpl implements OrderItemService {

    OrderITemDAO orderITemDAO = new OrderITemDAOImpl();
    @Override
    public List<OrderItem> queryOrderItem() {
        return orderITemDAO.queryOrderItem();
    }

    @Override
    public List<OrderItem> queryOrderItemById(String id) {

        return orderITemDAO.queryOrderItemById(id);
    }
}
