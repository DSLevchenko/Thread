package com.brainacad.oop.testGeneric;

/**
 * Created by Admin on 25.04.2017.
 */
public class MyRunable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable"+Thread.currentThread().getName());  //currentThread() - возвращает обект Thread текущего потока и у него  getName

    }
}
