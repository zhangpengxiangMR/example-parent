package com.pykj.annotation.project.service;

import com.pykj.annotation.project.dao.MyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/13 18:14
 */
@Service
public class MyService {

   /* @Qualifier("dao")
    @Autowired*/
    //@Resource(name = "resourceDao")
    @Autowired
    public MyDao myDao;

    public void print(){
        System.out.println(myDao);
    }

}
