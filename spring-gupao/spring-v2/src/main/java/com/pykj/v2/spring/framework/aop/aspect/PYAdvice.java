package com.pykj.v2.spring.framework.aop.aspect;

import java.lang.reflect.Method;

/**
 * 通知类advice(一个方法对应多个通知)
 */
public class PYAdvice {

    /**
     * 切入类
     */
    private Object aspect;

    /**
     * 通知方法
     */
    private Method adviceMethod;

    /**
     * 异常名称
     */
    private String thowName;

    public PYAdvice(Object aspect, Method adviceMethod) {
        this.aspect = aspect;
        this.adviceMethod = adviceMethod;
    }

    public Object getAspect() {
        return aspect;
    }

    public void setAspect(Object aspect) {
        this.aspect = aspect;
    }

    public Method getAdviceMethod() {
        return adviceMethod;
    }

    public void setAdviceMethod(Method adviceMethod) {
        this.adviceMethod = adviceMethod;
    }

    public String getThowName() {
        return thowName;
    }

    public void setThowName(String thowName) {
        this.thowName = thowName;
    }
}
