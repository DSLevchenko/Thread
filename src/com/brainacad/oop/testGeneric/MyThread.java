package com.brainacad.oop.testGeneric;

/**
 * Created by Admin on 25.04.2017.
 */
public class MyThread extends  Thread{
    @Override                         //что хотим реализовать в потоке - необходимо описать в методе run
    public void run() {
        System.out.println("Thread started"+ this.getName());
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread finished"+ this.getName());
    }
    }

