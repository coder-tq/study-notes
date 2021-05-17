package 尚硅谷面试题第二季;

import java.util.concurrent.TimeUnit;

/**
 * @author coder_tq
 * @Date 2021/5/17 14:09
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        String lock1 = "lock1";
        String lock2 = "lock2";
        new Thread(new HoldLockThread(lock1,lock2),"AA").start();
        new Thread(new HoldLockThread(lock2,lock1),"BB").start();

    }
}
class HoldLockThread implements Runnable{

    private final String lock1;
    private final String lock2;

    public HoldLockThread(String lock1, String lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized(lock1){
            System.out.println(Thread.currentThread().getName()+"占有锁："+lock1+" 尝试获取:"+lock2);
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            synchronized(lock2){
                System.out.println(Thread.currentThread().getName()+"占有锁："+lock1+" "+lock2);
            }
        }
    }
}
