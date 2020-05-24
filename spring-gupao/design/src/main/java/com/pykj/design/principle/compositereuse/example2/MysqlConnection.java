package com.pykj.design.principle.compositereuse.example2;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/20 22:52
 */
public class MysqlConnection extends DBConnection {

    @Override
    public String getConnection() {
        return "mysql 数据库连接";
    }
}
