package com.pykj.gupao.concurrency.chapter3;

import java.util.concurrent.TimeUnit;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/5/23 17:12
 */
public class VolatileDemo {


    public static volatile boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开始：" + Thread.currentThread().getName());
        Thread thread = new Thread(()->{
            int i = 0;
            while (!stop) {
                i++;
//                try {
//                    Thread.sleep(0);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
            System.out.println("rs:" + i + "-" + Thread.currentThread().getName());
        });
        thread.start();
        //Thread.sleep(1000);
        TimeUnit.SECONDS.sleep(10);
        stop = true;
        System.out.println("主线程结束：" + Thread.currentThread().getName());
    }

}
