package com.pykj.v2.spring.framework.aop;

public interface PYAopProxy {

    Object getProxy();

    Object getProxy(ClassLoader classLoader);


}
