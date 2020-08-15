package com.mitsuha.thread;

/**
 * @author MitsuhaCon
 * @className ThreadDemo
 * @deacription 开启 多线程之旅
 * @date 2020/7/23 14:59
 **/
public class ThreadDemo implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() +  "--------" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "*" + i);
        }
        new Thread(new ThreadDemo()).start();
    }
}
