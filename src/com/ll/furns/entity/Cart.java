package com.ll.furns.entity;

import com.ll.furns.dao.BasicDAO;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Set;

public class Cart {

    private HashMap<Integer, CartItem> items = new HashMap<>();
    // private Integer totalCount = 0;


    public boolean isEmpty(){
        return items.size() == 0;
    }
    public void delItem(int id){
        items.remove(id);
    }
    public void clear(){
        items.clear();
    }

    public void updateCount(int id, int count) {
        CartItem item = items.get(id);
        if (item != null) {
            item.setCount(count);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        } else {

        }
    }

    public BigDecimal getCartTotalPrice() {
        BigDecimal cartTotalPrice = new BigDecimal(0);
        Set<Integer> integers = items.keySet();
        for (Integer integer : integers) {
            CartItem item = items.get(integer);
            cartTotalPrice = cartTotalPrice.add(item.getTotalPrice());
        }

        return cartTotalPrice;
    }

    public HashMap<Integer, CartItem> getItems() {
        return items;
    }

    public Integer getTotalCount() {
        int totalCount = 0;
        Set<Integer> integers = items.keySet();
        for (Integer id : integers) {
            totalCount += ((CartItem) items.get(id)).getCount();
        }
        return totalCount;
    }

    public void addItem(CartItem cartItem) {
        CartItem item = items.get(cartItem.getId());
        if (item == null) {
            items.put(cartItem.getId(), cartItem);
        } else {
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                '}';
    }
}
