package com.pykj.gupao.concurrency.chapter1;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/6/6 22:34
 */
/*public class InterruptDemo implements Runnable {

    private int i = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("Test:" + i++);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new InterruptDemo());
        thread.start();
    }
}*/
public class InterruptDemo implements Runnable {

    private int i = 0;

    @Override
    public void run() {
        //Thread.currentThread().isInterrupted()默认是false
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Test:" + i++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptDemo());
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
        //thread.interrupt 设置interrupted为true
    }
}