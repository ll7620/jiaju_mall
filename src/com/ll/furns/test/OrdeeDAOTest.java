package com.ll.furns.test;

import com.ll.furns.dao.OrderDAO;
import com.ll.furns.dao.impl.OrderDAOImpl;
import com.ll.furns.entity.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

public class OrdeeDAOTest {
    OrderDAO orderDAO = new OrderDAOImpl();
    @Test
    public void SaveOrder(){
        Order sn00002 = new Order("sn00002", new Date(), new BigDecimal(200), 0, 2);
        int i = orderDAO.saveOrder(sn00002);
        System.out.println(i);
    }


}
