package com.pykj.design.principle.singleresponsibility.example3;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/20 0:12
 */
public interface ICourseInfo {

    String getCourseName();
    //获得视频流
    byte[] getCourseVideo();
}
