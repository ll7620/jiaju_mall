package com.ll.furns.web;

import com.ll.furns.entity.Furn;
import com.ll.furns.entity.Page;
import com.ll.furns.service.FurnService;
import com.ll.furns.service.impl.FurnServiceImpl;
import com.ll.furns.utils.DataUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static com.ll.furns.entity.Page.PAGE_SIZE;


public class CustomerServlet extends BasicServlet {
    FurnService furnService = new FurnServiceImpl();


    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = DataUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = DataUtils.parseInt(req.getParameter("pageSize"), 4);

        Page<Furn> page = furnService.page(pageNo, pageSize);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/views/customer/index.jsp").forward(req, resp);
    }

/*    protected void showFurn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = DataUtils.parseInt(req.getParameter("id"), 0);
        Furn furn = furnService.queryFurnById(id);
        req.setAttribute("furn", furn);
        req.getRequestDispatcher("/views/customer/index.jsp").forward(req, resp);
    }*/

    protected void pageByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = DataUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = DataUtils.parseInt(req.getParameter("pageSize"), 4);
        String name = req.getParameter("name");
        if (name == null) {
            name = "";
        }
        Page<Furn> page = furnService.pageByName(pageNo, pageSize, name);
        StringBuilder url = new StringBuilder("customerServlet?action=pageByName");
        if (!"".equals(name)) {
            url.append(("&name=" + name));
        }
        page.setUrl(url.toString());

        req.setAttribute("page", page);
        req.getRequestDispatcher("/views/customer/index.jsp").forward(req, resp);
    }

}
