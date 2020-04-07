package com.pykj.v2.spring.framework.webmvc.servlet;

import com.pykj.v2.spring.framework.context.PYApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * DispatcherServlet用到委派模式
 * 职责：负责任务调度，请求分发
 *
 */
public class PyDispatcherServlet extends HttpServlet {

    private PYApplicationContext pyApplicationContext;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //初始化Spring核心IoC容器
        pyApplicationContext = new PYApplicationContext(config.getInitParameter("contextConfigLocation"));

    }
}
