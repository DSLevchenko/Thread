import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Admin on 27.04.2017.
 */
public class ReetrantLockSample {
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock(); //первый зашедший поток блокирует пременную lock
                System.out.println("Thread1 locked "+lock.isLocked());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread1 unlocked1 "+lock.isLocked());
                lock.unlock(); //сколько раз был лок, столько же должен быть анлок.

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock(); //первый зашедший поток блокирует пременную lock
                System.out.println("Thread2 locked  "+lock.isLocked());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                lock.unlock();
                System.out.println("Thread2 unlocked2 "+lock.isLocked());
            }
        }).start();

    }

}
