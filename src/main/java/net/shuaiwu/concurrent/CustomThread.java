package net.shuaiwu.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 自定义线程类
 *
 * @author shuaiwu
 * @date 2023-11-20 16:35
 */
public class CustomThread {

    private class ThreadOne extends Thread {

        @Override
        public void run() {
            System.out.println("ThreadOne Run...");

            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class ThreadTwo implements Runnable {

        @Override
        public void run() {
            System.out.println("ThreadTwo Run...");
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class ThreadThree implements Callable {
        @Override
        public Object call(){
            System.out.println("ThreadThree Call...");
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return null;
        }
    }

    private class CustomThreadPool {

        private void ThreadTwo(){
            ExecutorService executorService = Executors.newFixedThreadPool(1);
            executorService.submit(new ThreadTwo());
        }

        private void ThreadThree(){
            ExecutorService executorService = Executors.newFixedThreadPool(1);
            executorService.submit(new ThreadThree());
        }
    }


    public static void main(String[] args) {
//        CustomThreadPool customThreadPool = new CustomThread().new CustomThreadPool();
//        customThreadPool.ThreadTwo();
//        customThreadPool.ThreadThree();

//        ThreadOne threadOne = new CustomThread().new ThreadOne();
//        threadOne.start();
//
//        ThreadTwo threadTwo = new CustomThread().new ThreadTwo();
//        threadTwo.run();
//
//        ThreadThree threadThree = new CustomThread().new ThreadThree();
//        threadThree.call();
    }
}
