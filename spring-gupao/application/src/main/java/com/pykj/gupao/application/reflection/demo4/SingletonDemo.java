package com.pykj.gupao.application.reflection.demo4;

/**
 * @description: 反射可以破坏单例
 * @author: zhangpengxiang
 * @time: 2020/6/27 22:15
 */
public class SingletonDemo {

    public static void main(String[] args) throws Exception {

       /* Lazy lazy = Lazy.getInstance();

        Constructor constructor = Lazy.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Lazy lazy1 = (Lazy) constructor.newInstance();
        System.out.println(lazy == lazy1);*/


        new Thread(()->{
            while (true) {
                System.out.println(Lazy.getInstance());
            }
        },"Thread1").start();

        new Thread(()->{
            while (true) {
                System.out.println(Lazy.getInstance());
            }
        },"Thread2").start();

        new Thread(()->{
            while (true) {
                System.out.println(Lazy.getInstance());
            }
        },"Thread3").start();

    }

}
