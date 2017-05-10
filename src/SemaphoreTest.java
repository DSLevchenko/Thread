import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 03.05.2017.
 */
public class SemaphoreTest {
    private static final Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) {

        //semaphore.release();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        long id = Thread.currentThread().getId();

                        System.out.println(id + " Waiting...");
                        semaphore.acquire();

                        System.out.println(id + " Running");
                        TimeUnit.SECONDS.sleep(3);

                        semaphore.release();
                        System.out.println(id + " Release");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
