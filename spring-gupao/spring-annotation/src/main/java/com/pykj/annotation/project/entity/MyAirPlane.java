package com.pykj.annotation.project.entity;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @description: 飞机类
 * @author: zhangpengxiang
 * @time: 2020/4/15 17:21
 */
@Component
public class MyAirPlane {

    public MyAirPlane() {
        System.out.println("调用MyAirPlane的构造方法");
    }

    //在构造方法之后调用这个方法
    @PostConstruct
    public void addOil() {
        System.out.println("飞机起飞前加油");
    }

    public void run() {
        System.out.println("飞机空中巡航");
    }

    //销毁之前调用这个方法
    @PreDestroy
    public void close() {
        System.out.println("飞机落地熄火");
    }
}
