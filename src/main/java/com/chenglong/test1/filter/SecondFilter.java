package com.chenglong.test1.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 整合Filter方式2
 */

public class SecondFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入Second Filter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("离开Second Filter");
    }

    @Override
    public void destroy() {

    }
}
