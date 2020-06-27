package com.pykj.gupao.application.reflection.demo3;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/6/14 19:51
 */
public class Person {

    public String name;

    private int age;

    public void talk() {
        System.out.println(name + ",正在说话");
    }

    private void say() {
        System.out.println(name + ",正在说话");
    }

}
