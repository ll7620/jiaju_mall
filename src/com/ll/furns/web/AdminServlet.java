package com.ll.furns.web;

import com.ll.furns.entity.Admin;
import com.ll.furns.entity.Member;
import com.ll.furns.service.AdminService;
import com.ll.furns.service.impl.AdminServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AdminServlet extends BasicServlet {
AdminService adminService = new AdminServiceImpl();
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Admin loginAdmin = adminService.login(new Admin(null,username,password));

        if(loginAdmin == null){
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/views/manage/manage_login.jsp").forward(req,resp);
        }
        else
        {
            Member member = new Member(null,username,password,"@qq.com");
            req.getSession().setAttribute("member",member);
            req.getRequestDispatcher("/views/manage/manage_menu.jsp").forward(req,resp);
        }
    }
}
