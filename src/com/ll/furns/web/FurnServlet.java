package com.ll.furns.web;

import com.ll.furns.entity.Furn;
import com.ll.furns.entity.Page;
import com.ll.furns.service.FurnService;
import com.ll.furns.service.impl.FurnServiceImpl;
import com.ll.furns.utils.DataUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static com.ll.furns.entity.Page.PAGE_SIZE;

public class FurnServlet extends BasicServlet {
    FurnService furnService = new FurnServiceImpl();

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String action = req.getParameter("action");
        List<Furn> furns = furnService.queryFurns();
        req.setAttribute("furns", furns);
        req.getRequestDispatcher("/views/manage/furn_manage.jsp").forward(req, resp);
    }


    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*        String name = req.getParameter("name");
        String maker = req.getParameter("maker");
        String price = req.getParameter("price");
        String sales = req.getParameter("sales");
        String stock = req.getParameter("stock");*/
     /*   Furn furn = new Furn();
        try {
            BeanUtils.populate(furn,req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        //int add = furnService.add(new Furn(null, name, maker, new BigDecimal(price), new Integer(sales), new Integer(stock), "assets/images/product-image/default.jpg"));
     //请求转发，刷新页面时，会重新提交，会重新发出一次请求
        //使用请求重定向
        //req.getRequestDispatcher("/manage/furnServlet?action=list").forward(req, resp);

        Furn furn = DataUtils.copyParamToBean(req.getParameterMap(),new Furn());
        furnService.add(furn);
        /*resp.sendRedirect(req.getContextPath()+"/manage/furnServlet?action=list");*/
        resp.sendRedirect(req.getContextPath()+"/manage/furnServlet?action=page&pageNo="+req.getParameter("pageNo"));

    }


    protected void deleteFurnById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = DataUtils.parseInt(req.getParameter("id"), 0);
        furnService.deleteFurnById(id);
        /*resp.sendRedirect(req.getContextPath()+"/manage/furnServlet?action=list");*/
        resp.sendRedirect(req.getContextPath()+"/manage/furnServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }


    protected void updateFurn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Furn furn = DataUtils.copyParamToBean(req.getParameterMap(),new Furn());
        int i = furnService.updateFurnById(furn);
      //  System.out.println(i);
       /* resp.sendRedirect(req.getContextPath()+"/manage/furnServlet?action=list");*/
        resp.sendRedirect(req.getContextPath()+"/manage/furnServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }


    protected void showFurn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = DataUtils.parseInt(req.getParameter("id"), 0);
        Furn furn = furnService.queryFurnById(id);
        req.setAttribute("furn", furn);
        req.getRequestDispatcher("/views/manage/furn_update.jsp").forward(req, resp);
    }


    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = DataUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = DataUtils.parseInt(req.getParameter("pageSize"), PAGE_SIZE);

        Page<Furn> page = furnService.page(pageNo, pageSize);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/views/manage/furn_manage.jsp").forward(req, resp);
    }

}
