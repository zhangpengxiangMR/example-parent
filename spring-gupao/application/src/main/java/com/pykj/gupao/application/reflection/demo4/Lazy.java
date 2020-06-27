package com.pykj.gupao.application.reflection.demo4;

/**
 * @description: 懒汉式单例模式
 * @author: zhangpengxiang
 * @time: 2020/6/27 19:08
 */
public class Lazy {

    private static Lazy lazy = null;

    /**
     * 私有化构造函数
     */
    private Lazy(){}

    /**
     * 提供全局访问点
     */
    /*public static Lazy getInstance() {
        if(lazy == null) {
            lazy = new Lazy();
            return lazy;
        }
        return null;
    }*/

    /**
     * 全局访问点
     * 双重检查锁
     */
    public static Lazy getInstance() {
        if(lazy == null) {
            synchronized (Lazy.class) {
                if(lazy == null) {
                    lazy = new Lazy();
                    return lazy;
                }
            }
        }
        return lazy;
    }
}
