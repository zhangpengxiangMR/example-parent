package com.pykj.v2;

import java.io.IOException;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/5/19 23:10
 */
public class SynchronizedDemo {

    static Integer count = 0;

    public static void incr() {

        synchronized (count) {

            try {

                Thread.sleep(1);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            count++;

        }

    }

    public static void main(String[] args) throws IOException, InterruptedException {

        for (int i = 0; i < 128; i++) {

            new Thread(() -> SynchronizedDemo.incr()).start();

        }

        Thread.sleep(5000);

        System.out.println("result:" + count);

    }

}

