package com.ll.furns.test;

import com.ll.furns.entity.Cart;
import com.ll.furns.entity.CartItem;
import com.ll.furns.service.OrderItemService;
import com.ll.furns.service.OrderService;
import com.ll.furns.service.impl.OrderItemServiceImpl;
import com.ll.furns.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

public class saveOrderServiceTest {
    OrderService orderService = new OrderServiceImpl();

    @Test
    public void saveO(){
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"北欧小沙发",new BigDecimal(200),2,new BigDecimal(400)));
        System.out.println(orderService.saveOrder(cart,1));

    }
}
