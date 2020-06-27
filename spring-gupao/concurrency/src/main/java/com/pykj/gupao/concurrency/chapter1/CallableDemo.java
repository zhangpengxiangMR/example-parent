package com.pykj.gupao.concurrency.chapter1;

import java.util.concurrent.*;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/6/6 16:30
 */
public class CallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Callable Demo start ");
        return "成功";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        CallableDemo callableDemo = new CallableDemo();
        Future<String> submit = executorService.submit(callableDemo);
        System.out.println(submit.get());
    }

}
