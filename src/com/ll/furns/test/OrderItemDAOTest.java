package com.ll.furns.test;

import com.ll.furns.dao.OrderDAO;
import com.ll.furns.dao.OrderITemDAO;
import com.ll.furns.dao.impl.OrderITemDAOImpl;
import com.ll.furns.entity.OrderItem;
import com.ll.furns.service.OrderItemService;
import com.ll.furns.service.impl.OrderItemServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class OrderItemDAOTest{
   OrderITemDAO orderItemDAO = new OrderITemDAOImpl();
   OrderItemService orderItemService = new OrderItemServiceImpl();
   @Test
   public void saveOrderItem(){
       OrderItem orderItem = new OrderItem(null, "北欧小沙发", new BigDecimal(200), 3, new BigDecimal(600), "sn00002");
       System.out.println(orderItemDAO.saveOrderItem(orderItem));
   }

   @Test
    public void qur(){
       List<OrderItem> orderItems = orderItemDAO.queryOrderItem();
       for (OrderItem orderItem : orderItems) {
           System.out.println(orderItem);
       }
   }

   @Test
    public void sss(){

       List<OrderItem> orderItems = orderItemDAO.queryOrderItemById("16805725938552");
       for (OrderItem orderItem : orderItems) {
           System.out.println(orderItem);
       }
   }
}
