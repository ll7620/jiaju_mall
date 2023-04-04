package com.ll.furns.web;

import com.google.gson.Gson;
import com.ll.furns.entity.Cart;
import com.ll.furns.entity.CartItem;
import com.ll.furns.entity.Furn;
import com.ll.furns.service.FurnService;
import com.ll.furns.service.impl.FurnServiceImpl;
import com.ll.furns.utils.DataUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;

public class CartServlet extends BasicServlet{

    private FurnService furnService = new FurnServiceImpl();


    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart != null){
            cart.clear();
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void delItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = DataUtils.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart != null){
            cart.delItem(id);
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = DataUtils.parseInt(req.getParameter("id"), 0);
        int count = DataUtils.parseInt(req.getParameter("count"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart != null){
            cart.updateCount(id,count);
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int id = DataUtils.parseInt(req.getParameter("id"), 1);

        Furn furn = furnService.queryFurnById(id);

        CartItem item = new CartItem(furn.getId(), furn.getName(), furn.getPrice(), 1, furn.getPrice());

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(item);
        //System.out.println(cart);

        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void addItemByAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = DataUtils.parseInt(req.getParameter("id"), 1);

        Furn furn = furnService.queryFurnById(id);

        CartItem item = new CartItem(furn.getId(), furn.getName(), furn.getPrice(), 1, furn.getPrice());

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(item);
        //System.out.println(cart);
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("totalCartCount",cart.getTotalCount());
        String resultJson = new Gson().toJson(resultMap);
        resp.getWriter().write(resultJson);

    }


}
