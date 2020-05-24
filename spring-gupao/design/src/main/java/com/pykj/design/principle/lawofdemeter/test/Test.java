package com.pykj.design.principle.lawofdemeter.test;

import com.pykj.design.principle.lawofdemeter.example1.Boss;
import com.pykj.design.principle.lawofdemeter.example1.TeamLeader;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/20 16:36
 */
public class Test {

    public static void main(String[] args) {
        /*Boss boss = new Boss();
        TeamLeader teamLeader = new TeamLeader();
        boss.commandCheckNumber(teamLeader);*/

        //根据迪米特原则，Boss只想要看结果，不需要跟Course直接交流，而TeamLeader统计需要引用Course对象
        //Boss和Course并不是朋友。

        Boss boss = new Boss();
        boss.commandCheckNumber(new TeamLeader());

    }

}
