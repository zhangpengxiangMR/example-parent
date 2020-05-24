package com.pykj.design.patterns.factorypattern.simplefactorypattern.example;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/20 23:31
 */
public class Test {

    public static void main(String[] args) {
        ICourse iCourse = new JavaCourse();
        iCourse.record();
    }
}
