package com.ll.furns.Filter;

import com.ll.furns.utils.JDBCUtilsByDruid;

import javax.servlet.*;
import java.io.IOException;
import java.sql.SQLException;

public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest, servletResponse);
            JDBCUtilsByDruid.commit();
        } catch (Exception e) {
            try {
                JDBCUtilsByDruid.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(e);
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
