package com.pykj.design.principle.lawofdemeter.example1;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/20 16:34
 */
public class Boss {

    public void commandCheckNumber(TeamLeader teamLeader) {
        teamLeader.checkNumberOfCourse();
    }

}
