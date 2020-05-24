package com.pykj.ykz.chapter4.intercept;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/21 10:57
 */
public class MyInterceptor implements Interceptor{
    @Override
    public boolean before() {
        System.out.println("before");
        return true;
    }

    @Override
    public void after() {
        System.out.println("after");
    }

    @Override
    public Object around(Invocation invocation) throws Exception {
        System.out.println("around before....");
        Object obj = invocation.proceed();
        System.out.println("around after");
        return obj;
    }

    @Override
    public void afterReturning() {
        System.out.println("afterReturning");
    }

    @Override
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }

    @Override
    public boolean useAround() {
        return true;
    }
}
