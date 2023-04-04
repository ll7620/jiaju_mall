package com.ll.furns.test;

import com.ll.furns.entity.Cart;
import com.ll.furns.entity.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

public class cartTest {

    private Cart cart = new Cart();
    @Test
    public void addItem(){
        cart.addItem(new CartItem(1,"沙发",new BigDecimal(10),2,new BigDecimal(20)));
        cart.addItem(new CartItem(2,"沙发",new BigDecimal(10),2,new BigDecimal(20)));
        System.out.println("cart:"+cart);
    }
}
