package com.brainacad.oop.testGeneric;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Admin on 25.04.2017.
 */
public class ThreadPool {
    private static ExecutorService executorService = Executors.newSingleThreadExecutor();  //Позволяет выполнять потоки через пул потоков.
    private static ExecutorService executorService1 = Executors.newFixedThreadPool(4);
    public static void main(String[] args) {

        for (int i = 0; i <10 ; i++) {
            final int val = i;
            executorService1.submit(new Runnable() { //создается анонимный класс Runnable
                @Override
                public void run() {
                    System.out.println("start" + val);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("end"+val);
                }
            });
        }
        executorService1.shutdown(); //останавливетя поток в  executorService
    }
}
