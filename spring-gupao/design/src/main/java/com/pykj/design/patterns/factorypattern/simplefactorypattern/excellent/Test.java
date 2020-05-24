package com.pykj.design.patterns.factorypattern.simplefactorypattern.excellent;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/20 23:31
 */
public class Test {

    public static void main(String[] args) {
        ICourse java = CourseFactory.create("java");
        java.record();
        ICourse python = CourseFactory.create("python");
        python.record();
    }
}
