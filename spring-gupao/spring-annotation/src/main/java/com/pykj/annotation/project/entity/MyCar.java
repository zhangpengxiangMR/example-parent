package com.pykj.annotation.project.entity;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/15 17:03
 */
public class MyCar {

    public MyCar() {
        System.out.println("调用MyCar的构造方法");
    }

    public void addOil() {
        System.out.println("行驶前加油");
    }

    public void run() {
        System.out.println("正在飙车");
    }

    public void close() {
        System.out.println("停车熄火");
    }

}
