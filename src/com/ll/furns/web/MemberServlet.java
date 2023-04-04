package com.ll.furns.web;

import com.google.gson.Gson;
import com.ll.furns.entity.Member;
import com.ll.furns.service.MemberService;
import com.ll.furns.service.impl.MemberServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class MemberServlet extends BasicServlet {
    MemberService memberService = new MemberServiceImpl();


    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if("login".equals(action)){
            login(request,response);
        }
        else if ("register".equals(action)){
            register(request,response);
        }
        else {
            response.getWriter().write("请求参数action有误");
        }
    }*/

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Member member = memberService.login(new Member(null, username, password, null));
        if (member == null) {
            // System.out.println("登录失败");
            request.setAttribute("msg", "用户名或密码错误");
            request.setAttribute("username", username);
            request.getRequestDispatcher("/views/member/login.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("member", member);
            //System.out.println("登录成功");
            request.getRequestDispatcher("/views/member/login_ok.jsp").forward(request, response);
        }
    }

    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        if (token != null && token.equalsIgnoreCase(code)) {

            if (!memberService.isExistsUsername(username)) {
                //  System.out.println("用户名"+username+"不存在,可以注册");
                Member member = new Member(null, username, password, email);
                if (memberService.registerMember(member)) {
                    //System.out.println("注册成功");
                    request.getRequestDispatcher("/views/member/register_ok.html").forward(request, response);
                } else
                    //System.out.println("注册失败");
                    request.getRequestDispatcher("/views/member/register_fail.html").forward(request, response);
            } else
                //System.out.println("用户名"+username+"存在，不可注册");
                request.getRequestDispatcher("/views/member/login.jsp").forward(request, response);
        } else {
            request.setAttribute("msg", "验证码不正确·");
            request.setAttribute("active","register");
            request.setAttribute("username",username);
            request.setAttribute("email",email);
            request.getRequestDispatcher("/views/member/login.jsp").forward(request,response);
        }
    }


    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }

    protected void isExistName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        boolean isExistsUsername = memberService.isExistsUsername(username);
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("isExist",isExistsUsername);
        String resultJson = new Gson().toJson(resultMap);
        response.getWriter().write(resultJson);

    }
}
