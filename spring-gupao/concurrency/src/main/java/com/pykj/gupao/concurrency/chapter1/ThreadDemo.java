package com.pykj.gupao.concurrency.chapter1;

import java.util.concurrent.TimeUnit;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/6/6 16:14
 */
public class ThreadDemo extends Thread {


    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread Demo start");
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();
        System.out.println("Thread Demo 执行完毕");
    }
}
