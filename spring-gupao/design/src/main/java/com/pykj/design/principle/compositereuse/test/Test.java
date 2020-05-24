package com.pykj.design.principle.compositereuse.test;

import com.pykj.design.principle.compositereuse.example2.OracleConnection;
import com.pykj.design.principle.compositereuse.example2.ProductDao;
import com.pykj.design.principle.compositereuse.example2.MysqlConnection;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/20 22:48
 */
public class Test {

    public static void main(String[] args) {

//        ProductDao productDao = new ProductDao();
//        productDao.setDbConnection(new DBConnection());
//        productDao.addProduct();
        //上述是非常典型的合成复用原则的应用场景，但是，就目前的设计来说，DBConection还不是一种抽象，不便于系统扩展，

        ProductDao productDao2 = new ProductDao();
        productDao2.setDbConnection(new MysqlConnection());
        productDao2.addProduct();
        productDao2.setDbConnection(new OracleConnection());
        productDao2.addProduct();


    }

}
