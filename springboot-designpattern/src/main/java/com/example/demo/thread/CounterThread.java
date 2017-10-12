package com.example.demo.thread;

/**
 * Created by jiaozhiguang on 2017/10/12.
 */
public class CounterThread extends Thread {

    private static int counter = 0;

    @Override
    public void run() {
        try {
            Thread.sleep((int)(Math.random()*100));
        } catch (InterruptedException e) {
        }
        counter ++;
    }


    public static void main(String[] args) throws InterruptedException {
        int num = 1000;
        Thread[] threads = new Thread[num];
        for(int i=0; i<num; i++){
            threads[i] = new CounterThread();
            threads[i].start();
        }

        for(int i=0; i<num; i++){
            threads[i].join();
        }

        System.out.println(counter);
    }

}
