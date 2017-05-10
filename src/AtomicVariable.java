import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Admin on 03.05.2017.
 */
public class AtomicVariable {
    static AtomicInteger val = new AtomicInteger(); //обертка для работы с целыми числами//обертка как для обычного Integer
    public static void main(String[] args) {
        val.set(10);
        for (int i = 0; i <5 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int  v = val.getAndIncrement();
                    int v1 = val.get(); //вернул значение после ++
                    System.out.println("Prev: "+v);
                    System.out.println("Prev: "+v1);
                }
            }).start();
        }
            }
}
