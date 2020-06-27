package com.pykj.tomcat.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/hello")
public class EncodingFilter implements Filter {

    public EncodingFilter() {
        System.out.println("执行EncodingFilter的构造方法...");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("执行EncodingFilter的init方法...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行EncodingFilter的doFilter方法...");
        servletRequest.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("执行EncodingFilter的destroy方法...");

    }
}
