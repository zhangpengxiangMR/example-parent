package com.pykj.design.principle.singleresponsibility.example;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/20 0:01
 */
public class Course {

    public void study(String courseName){
        if("直播课".equals(courseName)) {
            System.out.println(courseName + "不能快进");
        }else {
            System.out.println(courseName + "可以反复回看");
        }
    }

}
