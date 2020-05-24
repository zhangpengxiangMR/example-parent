package com.pykj.design.principle.lawofdemeter.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/20 16:33
 */
public class TeamLeader {

    public void checkNumberOfCourse(){
        List<Course> courseList = new ArrayList<Course>();
        for (int i = 0; i < 20; i++) {
            courseList.add(new Course());
        }
        System.out.println("目前已发布的课程数量是：" + courseList.size());
    }

}
