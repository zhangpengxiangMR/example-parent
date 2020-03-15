package com.pykj.tomcat.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/hello")
public class TestFilter implements Filter {

    public TestFilter() {
        System.out.println("执行TestFilter的构造方法...");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("执行TestFilter的init()方法...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行TestFilter的doFilter()方法...");
        filterChain.doFilter(servletRequest,servletResponse);
        System.err.println("doFilter结束.............");
        System.err.println("doFilter结束.............");
    }

    @Override
    public void destroy() {
        System.out.println("执行TestFilter的destroy()方法...");
    }
}
