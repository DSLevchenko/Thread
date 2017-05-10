package com.brainacad.oop.testGeneric;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            MyThread myThread = new MyThread();
            myThread.setName("MyThread");

            myThread.setDaemon(true); //если приложение setDaemon(true) то прилодение не ждет завершение потоков.
            myThread.start();
            System.out.println(myThread.getState());
            //myThread.interrupt(); //exception
        }

        /*Thread thread = new Thread(new MyRunable());
        thread.setName("Test"); //сет имя потока
        thread.setPriority(10);// Приоритет. чем выше цифр - тем больше приоритет выполнения
        thread.setDaemon(false);//

        thread.start();
        System.out.println(thread.getId()); // система раздает ID
        System.out.println(thread.getName()); //имя потока
        //thread.interrupt(); //прерывает выполнение потока(не очень хороший прием)*/
    }
}
