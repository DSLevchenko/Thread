import static java.lang.Thread.sleep;

/**
 * Created by Admin on 27.04.2017.
 */
public class VolotileSample {
    static volatile int val = 0;
    public static void main(String[] args) {
        new Thread(new Runnable() { //интерфейс с методом run
            @Override
            public void run() {
                int LocalVal = val;
                while (LocalVal <5){
                    if(LocalVal != val){  //этот val кешируется и не обращается к глобальной - и для этого при ее обьвлении мы пишем volotile
                        System.out.println("Local val = " +val);
                        LocalVal = val;
                    }

                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int LocalVal = val;
                while (val <5){
                    System.out.println("Increment val to  "+ (LocalVal+1));
                    val = ++LocalVal;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).run();
    }
}
