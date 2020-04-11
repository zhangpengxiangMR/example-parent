package com.pykj.v2.spring.framework.webmvc.servlet;


import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class PYHandlerMapping {
    /**
     *URL
     */
    private Pattern pattern;

    /**
     *对应的method
     */
    private Method method;

    /**
     *Method对应的实例化对象
     */
    private Object controller;

    public PYHandlerMapping(Pattern pattern, Object controller,Method method) {
        this.pattern = pattern;
        this.method = method;
        this.controller = controller;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object getController() {
        return controller;
    }

    public void setController(Object controller) {
        this.controller = controller;
    }
}
