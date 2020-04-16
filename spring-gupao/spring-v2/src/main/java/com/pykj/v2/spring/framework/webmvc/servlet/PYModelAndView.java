package com.pykj.v2.spring.framework.webmvc.servlet;

import java.util.Map;

public class PYModelAndView {
    /**
     * 返回的页面
     */
    private String viewName;
    /**
     * 数据
     */
    private Map<String,?> model;

    public PYModelAndView(String viewName, Map<String, ?> model) {
        this.viewName = viewName;
        this.model = model;
    }

    public PYModelAndView(String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }

    public Map<String, ?> getModel() {
        return model;
    }
}


