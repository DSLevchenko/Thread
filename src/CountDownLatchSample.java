import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 03.05.2017.
 */
public class CountDownLatchSample {
    static CountDownLatch  latch = new CountDownLatch(4);

    public static void main(String[] args) {
        for (int i = 0; i < 4 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread"+ Thread.currentThread().getId());

                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                        latch.countDown();
                }
            }).start();
        }

        System.out.println("Waiting..."); //этот блок в основном потоке и выполнится когда счетчик будет 0
        try {
            latch.await(); //приостанавливает текущий поток(в котором он вызван)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished");
    }
}
