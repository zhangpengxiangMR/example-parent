package com.pykj.tomcat.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

//@WebServlet("/helloServlet")
public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("创建servlet对象");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("对servlet完成初始化操作...");
        System.out.println("getServletName()" + servletConfig.getServletName());
        System.out.println("getInitParameter()" + servletConfig.getInitParameter("username"));
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String s = initParameterNames.nextElement();
            System.out.println("getInitParameterNames()" + s);
        }
        ServletContext servletContext = servletConfig.getServletContext();
        System.out.println("servletContext.getInitParameter()" + servletContext.getInitParameter("username"));
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("执行了servlet的业务方法...");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("释放了Servlet对象...");
    }
}
