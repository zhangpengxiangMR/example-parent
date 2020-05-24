package com.pykj.design.principle.lawofdemeter.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/20 16:34
 */
public class Boss {

    public void commandCheckNumber(TeamLeader teamLeader){
        List<Course> courseList = new ArrayList<Course>();
        for (int i = 0; i < 20; i++) {
            courseList.add(new Course());
        }
        teamLeader.checkNumberOfCourse(courseList);
    }

}
