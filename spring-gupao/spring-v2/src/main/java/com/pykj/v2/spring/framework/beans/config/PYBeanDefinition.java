package com.pykj.v2.spring.framework.beans.config;

/**
 * bean定义
 * 职责：保存类的名称和类全路径名称
 */
public class PYBeanDefinition {

    /**
     * bean名称(active)
     */
    private String factoryBeanName;

    /**
     * bean全路径(com.pykj.active)
     */
    private String beanClassName;

    public String getFactoryBeanName() {
        return factoryBeanName;
    }

    public void setFactoryBeanName(String factoryBeanName) {
        this.factoryBeanName = factoryBeanName;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
    }
}
