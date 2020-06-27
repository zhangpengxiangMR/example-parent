package com.pykj.gupao.application.reflection.demo4;

/**
 * @description: 饥饿式单例模式
 * @author: zhangpengxiang
 * @time: 2020/6/27 19:05
 */
public class Hungry {

    private static final Hungry hungry = new Hungry();

    /**
     * 私有化构造函数
     */
    private Hungry(){}

    /**
     * 提供唯一全局访问点
     */

    public static Hungry getInstance() {
        return hungry;
    }


}
