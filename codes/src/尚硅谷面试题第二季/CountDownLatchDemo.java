package 尚硅谷面试题第二季;

import java.util.concurrent.CountDownLatch;

/**
 * @author coder_tq
 * @Date 2021/5/13 20:23
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"号同学离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println("班长锁门");

    }
}
