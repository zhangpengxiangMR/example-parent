package com.pykj.ykz.chapter4.intercept;

import java.lang.reflect.Method;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/21 13:48
 */
public interface InvocationHandler extends java.lang.reflect.InvocationHandler {

    /**
     * 处理代理对象方法逻辑
     * @param proxy     代理对象
     * @param method    当前方法
     * @param args      运行参数
     * @return          方法调用结果
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args);

}
