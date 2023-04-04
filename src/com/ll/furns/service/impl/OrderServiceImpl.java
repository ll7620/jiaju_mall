package com.ll.furns.service.impl;

import com.ll.furns.dao.FurnDAO;
import com.ll.furns.dao.OrderDAO;
import com.ll.furns.dao.OrderITemDAO;
import com.ll.furns.dao.impl.FurnDAOImpl;
import com.ll.furns.dao.impl.OrderDAOImpl;
import com.ll.furns.dao.impl.OrderITemDAOImpl;
import com.ll.furns.entity.*;
import com.ll.furns.service.FurnService;
import com.ll.furns.service.OrderItemService;
import com.ll.furns.service.OrderService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class OrderServiceImpl implements OrderService {
    OrderDAO orderDAO = new OrderDAOImpl();
    OrderITemDAO orderITemDAO = new OrderITemDAOImpl();
    FurnDAO furnDAO = new FurnDAOImpl();

    @Override
    public String saveOrder(Cart cart,int memberId) {

        String orderId = System.currentTimeMillis()+""+memberId;
        Order order = new Order(orderId, new Date(), cart.getCartTotalPrice(), 0, memberId);
        orderDAO.saveOrder(order);
        HashMap<Integer, CartItem> items = cart.getItems();
        Set<Integer> keys = items.keySet();
        for (Integer id : keys) {
            CartItem item = items.get(id);
            OrderItem orderItem = new OrderItem(null, item.getName(), item.getPrice(), item.getCount(), item.getTotalPrice(), orderId);
            orderITemDAO.saveOrderItem(orderItem);
            Furn furn = furnDAO.queryFurnById(id);
            furn.setSales(furn.getSales() + item.getCount());
            furn.setStock(furn.getStock() - item.getCount());
            furnDAO.updateFurnById(furn);
        }

        cart.clear();

        return orderId;
    }

    @Override
    public Order queryOrderById(int id) {
        return orderDAO.queryOrderById(id);
    }

    @Override
    public List<Order> queryOrders() {
        return orderDAO.queryOrders();
    }
}
