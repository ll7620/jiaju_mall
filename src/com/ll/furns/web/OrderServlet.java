package com.ll.furns.web;

import com.ll.furns.entity.*;
import com.ll.furns.service.FurnService;
import com.ll.furns.service.OrderItemService;
import com.ll.furns.service.OrderService;
import com.ll.furns.service.impl.FurnServiceImpl;
import com.ll.furns.service.impl.OrderItemServiceImpl;
import com.ll.furns.service.impl.OrderServiceImpl;
import com.ll.furns.utils.DataUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;


public class OrderServlet extends BasicServlet {

    private OrderService orderService = new OrderServiceImpl();
    private OrderItemService orderItemService = new OrderItemServiceImpl();



    protected void saveOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart == null || cart.isEmpty()){
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
            return;
        }
        Member member = (Member) req.getSession().getAttribute("member");
        if(member == null){
            req.getRequestDispatcher("/views/member/login.jsp").forward(req,resp);
            return;
        }

        String orderId = orderService.saveOrder(cart, member.getId());
        req.getSession().setAttribute("orderId",orderId);
    /*    int id = DataUtils.parseInt(orderId, 0);
        Order order = orderService.queryOrderById(id);
        req.getSession().setAttribute("order",order);*/

        resp.sendRedirect(req.getContextPath()+"/views/order/checkout.jsp");
    }

    protected void showOrderDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Number orderId = DataUtils.parseInt(req.getParameter("orderId"), 0);
        String orderId = req.getParameter("orderId");
        List<OrderItem> orderItems = orderItemService.queryOrderItemById(orderId);
        int totalCount = 0;
        BigDecimal totalAllPrice = new BigDecimal(0);
        for (OrderItem orderItem : orderItems) {
            totalCount += orderItem.getCount();
            totalAllPrice=totalAllPrice.add(orderItem.getTotalPrice());
        }
        req.getSession().setAttribute("totalCount",totalCount);
        req.getSession().setAttribute("totalAllPrice",totalAllPrice);
        req.getSession().setAttribute("orderItems", orderItems);
        req.getSession().setAttribute("orderId",orderId);
        resp.sendRedirect(req.getContextPath()+"/views/order/order_detail.jsp");
        //req.getRequestDispatcher("/views/order/order_detail.jsp").forward(req, resp);
    }

    protected void orderManage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderService.queryOrders();
        req.setAttribute("orders",orders);
        req.getRequestDispatcher("/views/order/order.jsp").forward(req, resp);
    }

}
