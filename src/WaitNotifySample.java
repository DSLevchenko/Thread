import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 27.04.2017.
 */
public class WaitNotifySample {
    private static ArrayList<Integer> list = new ArrayList<>(); //глобальная переменная


    public static void main(String[] args) {
        Thread thread1 = new Thread1();
        Thread thread2 = new Thread2();

        thread1.start();
        thread2.start();

        try {
            thread1.join(); //join ждет завершения потока - чтобы выполнить все что после него.
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finish");
    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (list) {  //обязателен для использования с White Notify
                System.out.println("Waiting...");
                try {
                    list.wait(); //Wait метод останавливает этот поток, пока не прийдет Notify. С ними обязательно использовать synchronized
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("List size: " + list.size());
            }
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() { //все что выполняется в потоке - выполняется в методе run
            for (int i = 0; i < 10; i++) {
                list.add((int) (Math.random() * 100));
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized (list) {
                list.notifyAll(); //служит для передачи в Wait - как команды для разблокирования данного обьекта.
            }
        }
    }


}
