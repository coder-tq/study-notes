package 尚硅谷面试题第二季;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author coder_tq
 * @Date 2021/5/9 16:29
 */
public class Volatile {
    public static void main(String[] args) {
        VolatileResource volatileResource = new VolatileResource();
        for (int i = 0; i < 200; i++) {
            new Thread(() -> {
                for (int j = 0; j < 200; j++) {
                volatileResource.increment();
                }
            },String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2){
            ;
        }
        System.out.println(volatileResource.i);
    }
}
class VolatileResource{
    public AtomicInteger i = new AtomicInteger(0);
    public void increment(){
        i.getAndIncrement();
    }
}
