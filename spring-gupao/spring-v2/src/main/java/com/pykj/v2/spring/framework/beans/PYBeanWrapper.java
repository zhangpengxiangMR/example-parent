package com.pykj.v2.spring.framework.beans;

/**
 * 保存bean的实例和class
 * Wrapper    ˈrapər
 */
public class PYBeanWrapper {

    /**
     * 类对象
     */
    private Object wrapperInstance;

    /**
     * 类class
     */
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
