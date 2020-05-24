package com.pykj.ykz.chapter4.intercept;

import java.lang.reflect.Method;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/21 10:48
 */
public class Invocation {

    private Object[] params;

    private Method method;

    private Object target;

    public Invocation( Object target,Method method,Object[] params) {
        this.params = params;
        this.method = method;
        this.target = target;
    }

    public Object proceed() throws Exception{
        return method.invoke(target,params);
    }
}
