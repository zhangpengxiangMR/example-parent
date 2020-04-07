package com.pykj.v2.spring.framework.beans;

public class PYBeanWrapper {

    private Object wrapperInstance;

    private Class<?> wrapperClass;

    public PYBeanWrapper(Object instance) {
        wrapperInstance = instance;
        wrapperClass = instance.getClass();
    }

    public Object getWrapperInstance() {
        return wrapperInstance;
    }

    public void setWrapperInstance(Object wrapperInstance) {
        this.wrapperInstance = wrapperInstance;
    }

    public Class<?> getWrapperClass() {
        return wrapperClass;
    }

    public void setWrapperClass(Class<?> wrapperClass) {
        this.wrapperClass = wrapperClass;
    }

}
