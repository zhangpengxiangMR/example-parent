package com.pykj.design.principle.compositereuse.example2;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/20 22:45
 */
public class ProductDao {

    private DBConnection dbConnection;

    public void setDbConnection(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void addProduct(){
        String conn = dbConnection.getConnection();
        System.out.println("使用" + conn + "增加产品");
    }
}
