package com.pykj.design.principle.dependenceinversion.example;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/19 23:06
 */
public class XiaoXiang {


    private ICourse iCourse;
    //通过构造器传入
   /* public XiaoXiang(ICourse iCourse) {
        this.iCourse = iCourse;
    }*/

    //如果xiaoxiang是全局单例的Bean，那么只能通过setICourse进行注入

    public void setiCourse(ICourse iCourse) {
        this.iCourse = iCourse;
    }

    public void study(){
        iCourse.study();
    }

}
