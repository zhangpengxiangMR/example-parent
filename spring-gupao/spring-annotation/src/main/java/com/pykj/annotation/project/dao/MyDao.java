package com.pykj.annotation.project.dao;

import org.springframework.stereotype.Repository;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/13 18:14
 */
@Repository
public class MyDao {

    private int flag = 1;

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "MyDao{" +
                "flag=" + flag +
                '}';
    }
}
