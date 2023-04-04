package com.ll.furns.Filter;

import com.google.gson.Gson;
import com.ll.furns.entity.Member;
import com.ll.furns.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AuthFilter implements Filter {
    private List<String> excludeUrls;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String strExcludeUrls = filterConfig.getInitParameter("excludeUrls");
        String[] splitUrl = strExcludeUrls.split(",");
        excludeUrls = Arrays.asList(splitUrl);
        System.out.println(excludeUrls);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();
        System.out.println("请求的url：" + requestURI);

        if (!excludeUrls.contains(requestURI)) {
            Member member = (Member) request.getSession().getAttribute("member");
            if (member == null) {
                if(!WebUtils.isAjaxRequest(request)){
                    request.getRequestDispatcher("/views/member/login.jsp").forward(servletRequest, servletResponse);
                    return;
                }
                else{
                    HashMap<String, Object> resultMap = new HashMap<>();
                    resultMap.put("url","views/member/login.jsp");
                    String resultJson = new Gson().toJson(resultMap);
                    servletResponse.getWriter().write(resultJson);
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
