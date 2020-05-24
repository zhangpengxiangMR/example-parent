package com.pykj.design.principle.dependenceinversion.test;

import com.pykj.design.principle.dependenceinversion.example.GoCourse;
import com.pykj.design.principle.dependenceinversion.example.JavaCourse;
import com.pykj.design.principle.dependenceinversion.example.PythonCourse;
import com.pykj.design.principle.dependenceinversion.example.XiaoXiang;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/19 19:55
 */
public class Test {

    /**
     * @description
     * 编写Tom类，把学习的课程创建在Tom类中，如果在进行扩展需要改动的比较多，也不符合开闭原则。
     * 建立ICourse接口，把公共进行提炼，创建study()方法，JavaCourse课程和PythonCourse课程分别实现Icourse，
     * xiaoxiang类只需要接收ICourse进行调用即可，在添加GoCourse课程，只需要添加一个类，传入xiaoxiang即可。
     */
    public static void main(String[] args) {
        /*Tom tom = new Tom();
        tom.studyJavaCourse();;
        tom.studyPythonCourse();*/

       /* XiaoXiang xiaoXiang = new XiaoXiang();
        xiaoXiang.study(new JavaCourse());
        xiaoXiang.study(new PythonCourse());
        //增加的GoCourse课程
        xiaoXiang.study(new GoCourse());*/

       /* XiaoXiang javaCourse = new XiaoXiang(new JavaCourse());
        javaCourse.study();
        XiaoXiang pythonCourse = new XiaoXiang(new PythonCourse());
        pythonCourse.study();
        XiaoXiang goCourse = new XiaoXiang(new GoCourse());
        goCourse.study();*/

        XiaoXiang javaCourse = new XiaoXiang();
        javaCourse.setiCourse(new JavaCourse());
        javaCourse.study();
        XiaoXiang pythonCourse = new XiaoXiang();
        pythonCourse.setiCourse(new PythonCourse());
        pythonCourse.study();
        XiaoXiang goCourse = new XiaoXiang();
        goCourse.setiCourse(new GoCourse());
        goCourse.study();

    }

}
