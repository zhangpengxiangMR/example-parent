package com.pykj.annotation.project.entity;

import org.springframework.beans.factory.annotation.Value;

/**
 * @description: 鸟类
 * @author: zhangpengxiang
 * @time: 2020/4/15 23:16
 */
public class Bird {

    /**
     * 1、@Value支持基本数据类型
     * 2、@Value支持Spring EL表达式
     * 3、支持从配置文件中取值
     */
    @Value("鹦鹉")
    private String neme;

    @Value("#{9-5}")
    private int age;

    @Value("${bird.color}")
    private String color;

    public Bird() {
    }

    public Bird(String neme, int age) {
        this.neme = neme;
        this.age = age;
    }

    public String getNeme() {
        return neme;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNeme(String neme) {
        this.neme = neme;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "neme='" + neme + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
