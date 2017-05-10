/**
 * Created by Admin on 27.04.2017.
 */
public class SynchronizedSamle {
    public static Integer val = 0;
    //static Object locked = new Object(); //используем для sinchronized

    public static void main(String[] args) {
        /*new NonSynchronizedThread("NonSync1").start();
        new NonSynchronizedThread("NonSync2").start();*/

        new SynchronizedThread("Sync1").start();
        new SynchronizedThread("Sync2").start();
    }


    private static void changeVal() {
        while (val < 5) {
            val++;
            System.out.println(String.format("%s: %d", Thread.currentThread().getName(), val));
        }
        val = 0;
    }

    static class SynchronizedThread extends Thread {

        public SynchronizedThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (SynchronizedThread.class) { //синхронизация по классу - если поток захватил этот класс - то другие потоки не имеют доступа к этому классу
              //synchronized (locked){ //Обеспечивает одновременно доступ только одному потоку. если поток зашед в блок с ключевым слово (блок synchronized), остальные потоки ждут пока пока зашедший поток не отработает.
                changeVal();                           //и в параметре мы указываем по чем нам нужно синхронизировать - к чему осуществлять синхронный доступ
            }                                           //и если поток захватил этот аргумент - то выполнить то что в блоке ниже.
        }                                                //обычно задается глобальный обьек, по которому делают синхнозицию. static Object locked = new Object();
    }                                                     //также можно применить  synchronized для метода

    static class NonSynchronizedThread extends Thread {
        public NonSynchronizedThread(String name) {
            super(name);
        }

        @Override
        public  /*synchronized*/ void run() { //Сннхронизация для методу, если внутри класса есть несколько потоков и они исп. олин метод класса.
            changeVal();
        }
    }
}
