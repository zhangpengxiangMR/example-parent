package com.pykj.gupao.application.reflection.demo6;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/6/27 23:01
 */
public class BeanConfig {

    private String id;
    private String clazz;
    private String factoryMethod;
    private String factoryBean;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getFactoryMethod() {
        return factoryMethod;
    }

    public void setFactoryMethod(String factoryMethod) {
        this.factoryMethod = factoryMethod;
    }

    public String getFactoryBean() {
        return factoryBean;
    }

    public void setFactoryBean(String factoryBean) {
        this.factoryBean = factoryBean;
    }
}
