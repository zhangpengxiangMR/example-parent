package com.pykj.v2.spring.framework.core;

public interface PYBeanFactory {

    public Object getBean(Class beanClass);

    public Object getBean(String beanName);

}
