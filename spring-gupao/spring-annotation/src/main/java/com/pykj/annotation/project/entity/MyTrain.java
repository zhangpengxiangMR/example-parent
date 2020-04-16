package com.pykj.annotation.project.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @description: 火车类
 * @author: zhangpengxiang
 * @time: 2020/4/15 17:14
 */
@Component
public class MyTrain implements InitializingBean, DisposableBean {

    @Override
    public void destroy() throws Exception {
        System.out.println("火车对象销毁");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("火车对象初始化");
    }
}
