package com.pykj.gupao.concurrency.chapter1;

import java.util.concurrent.TimeUnit;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/6/6 18:42
 */
class ThreadStatusDemo {

    public static void main(String[] args) {
        //阻塞状态
        //TIMED_WAITING (sleeping)
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "STATUS_01").start();
        //阻塞状态
        // WAITING (on object monitor)
        new Thread(() -> {
            while (true) {
                synchronized (ThreadStatusDemo.class) {
                    try {
                        ThreadStatusDemo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "STATUS_02").start();

        // TIMED_WAITING (sleeping)
        new Thread(new BlockedDemo(), "BLOCKEDdEMO_DEMO_01").start();
        // BLOCKED (on object monitor)
        new Thread(new BlockedDemo(), "BLOCKEDdEMO_DEMO_02").start();

    }

    static class BlockedDemo extends Thread {
        @Override
        public void run() {
            synchronized (BlockedDemo.class) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
