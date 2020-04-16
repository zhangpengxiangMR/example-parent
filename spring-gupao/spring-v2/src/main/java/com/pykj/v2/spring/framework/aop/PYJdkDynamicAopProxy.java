package com.pykj.v2.spring.framework.aop;

import com.pykj.v2.spring.framework.aop.aspect.PYAdvice;
import com.pykj.v2.spring.framework.aop.support.PYAdvisedSupport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public class PYJdkDynamicAopProxy implements InvocationHandler {

    private PYAdvisedSupport config;

    public PYJdkDynamicAopProxy(PYAdvisedSupport config) {
        this.config = config;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Map<String, PYAdvice> advices = config.getAdvices(method,null);
        Object returnValue;
        try {
            invokeAdivce(advices.get("before"));

            returnValue = method.invoke(this.config.getTarget(),args);

            invokeAdivce(advices.get("after"));
        }catch (Exception e){
            invokeAdivce(advices.get("afterThrow"));
            throw e;
        }
        return returnValue;
    }

    private void invokeAdivce(PYAdvice advice) {
        try {
            advice.getAdviceMethod().invoke(advice.getAspect());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建当前类的代理对象
     * @return
     */
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),this.config.getTargetClass().getInterfaces(),this);
    }
}
