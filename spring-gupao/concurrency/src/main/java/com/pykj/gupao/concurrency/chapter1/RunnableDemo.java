package com.pykj.gupao.concurrency.chapter1;

import java.util.concurrent.TimeUnit;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/6/6 16:23
 */
public class RunnableDemo implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Runnable Demo start");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableDemo());
        thread.start();
        System.out.println("Runnable main start");
    }


}
