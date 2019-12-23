package com.demo.filter;


import com.sun.net.httpserver.HttpExchange;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author: Dely
 * @Date: 2019/12/10 14:34
 */


@WebFilter("/hello/*")
public class HelloFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("已经出发过滤器");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("过滤器完成");
    }

    public void destroy() {

    }
}
