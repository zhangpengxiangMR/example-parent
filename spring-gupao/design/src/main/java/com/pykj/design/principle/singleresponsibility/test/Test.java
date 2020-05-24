package com.pykj.design.principle.singleresponsibility.test;

import com.pykj.design.principle.singleresponsibility.example2.LiveCourse;
import com.pykj.design.principle.singleresponsibility.example2.ReplayCourse;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/20 0:02
 */
public class Test {

    public static void main(String[] args) {
        /*Course course = new Course();
        course.study("直播课");
        course.study("录播课");*/
        //Course类现在有两种职责。现在有一个需求是对课程进行加密，直播课和录播课可能加墨逻辑不一样，
        //必须修改代码，但是可能修改代码逻辑会相互影响，容易带来不可预判的风险，

        LiveCourse liveCourse = new LiveCourse();
        liveCourse.study("直播课");
        ReplayCourse replayCourse = new ReplayCourse();
        replayCourse.study("录播课");
    }

}
