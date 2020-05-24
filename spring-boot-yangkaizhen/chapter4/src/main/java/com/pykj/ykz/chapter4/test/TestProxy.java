package com.pykj.ykz.chapter4.test;

import com.pykj.ykz.chapter4.intercept.MyInterceptor;
import com.pykj.ykz.chapter4.intercept.ProxyBean;
import com.pykj.ykz.chapter4.service.HelloService;
import com.pykj.ykz.chapter4.service.impl.HelloServiceImpl;
import com.pykj.ykz.chapter4.service.impl.HelloTest;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/21 11:31
 */
public class TestProxy {

    public static void main(String[] args) {
        test();
        //helloTest();
    }


    private static void test(){
        HelloService helloService = new HelloServiceImpl();
        HelloService proxy = (HelloService)ProxyBean.getProxyBean(helloService,new MyInterceptor());
        proxy.sayHello("zhangsan");
        System.out.println("\n####################name is null##############\n");
        proxy.sayHello(null);
    }

    private static void helloTest(){
        HelloTest helloTest = new HelloTest();
        HelloTest proxy = (HelloTest)ProxyBean.getProxyBean(helloTest,new MyInterceptor());
        proxy.sayHello("zhangsan");
        System.out.println("\n####################name is null##############\n");
        proxy.sayHello(null);
    }



}
