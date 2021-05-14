package 尚硅谷面试题第二季;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author coder_tq
 * @Date 2021/5/14 21:53
 */
public class ConditionDemo {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareResource.print(5);
            }
        },"AA").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareResource.print(10);
            }
        },"BB").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareResource.print(15);
            }
        },"CC").start();

    }
}

class ShareResource{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print(int time){
        lock.lock();
        try {
            while(number!=1) {
                c1.await();
            }
            while (number!=2){
                c2.await();
            }
            while (number!=3){
                c3.await();
            }
            for (int i = 0; i < time; i++) {
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
            switch (number){
                case 1:c2.signal();break;
                case 2:c3.signal();break;
                case 3:c1.signal();break;
                default:break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
