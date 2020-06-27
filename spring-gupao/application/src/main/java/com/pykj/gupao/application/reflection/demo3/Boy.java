package com.pykj.gupao.application.reflection.demo3;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/6/22 23:00
 */
public class Boy extends Person {

    public int height;

    private int weight;

    public static String boys;

    public Boy() {
        System.out.println("我是公有的默认无参数构造函数");
    }

    private Boy(int height) {
        System.out.println("我是私有的一个参数的构造函数");
        this.height = height;
    }

    public Boy(int height, int weight) {
        System.out.println("我是公有的两个参数的构造方法");
        this.height = height;
        this.weight = weight;
    }

    /**
     * 打篮球的公有方法
     */
    public static void playBasketball() {
        System.out.println("play basketball");
    }

    /**
     * 打篮球的公有方法
     */
    public static void playBasketball(String name) {
        System.out.println(name + "play basketball");
    }

    /**
     * 追女孩私有方法
     */
    private void pickUpGirl() {
        System.out.println("pick up girl");
    }

    /**
     * 追女孩私有方法
     */
    private void pickUpGirl(String name) {
        System.out.println(name + "pick up girl");
    }


}
