package com.pykj.ykz.chapter4.intercept;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/21 10:46
 */
public interface Interceptor {

    //事前方法
    public boolean before();

    //事后方法
    public void after();

    /**
     * 取代原有事件方法
     *
     * @param invocation 回调参数，可以通过它的proceed方法，回调原有事件
     * @return 原有事件返回对象
     */
    public Object around(Invocation invocation) throws Exception;

    //事后返回方法，事件没有发生异常执行
    public void afterReturning();

    //事后异常方法，当事件发生异常后执行
    public void afterThrowing();

    //是否使用around方法取代原有方法
    boolean useAround();

}
