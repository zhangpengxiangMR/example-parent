package com.pykj.design.principle.compositereuse.example2;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/20 22:53
 */
public class OracleConnection extends DBConnection {

    @Override
    public String getConnection() {
        return "Oracle 数据库连接";
    }
}
