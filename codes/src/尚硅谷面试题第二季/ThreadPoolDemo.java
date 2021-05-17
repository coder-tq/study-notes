package 尚硅谷面试题第二季;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author coder_tq
 * @Date 2021/5/16 10:41
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        ExecutorService executorService1 = Executors.newCachedThreadPool();
//        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
//        ExecutorService executorService3 = Executors.newWorkStealingPool();
        ExecutorService executorService = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(4),
                new MyThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        try {
            for (int i = 0; i < 10; i++) {
                executorService.submit(new MyThread());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }
}
class MyThreadFactory implements ThreadFactory{
    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private final ThreadGroup group;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;

    MyThreadFactory() {
        SecurityManager s = System.getSecurityManager();
        group = (s != null) ? s.getThreadGroup() :
                Thread.currentThread().getThreadGroup();
        namePrefix = poolNumber.getAndIncrement() + " 号线程池的第 ";
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(group, r,
                namePrefix + threadNumber.getAndIncrement()+" 号线程。",
                0);
        if (t.isDaemon()) {
            t.setDaemon(false);
        }
        if (t.getPriority() != Thread.NORM_PRIORITY) {
            t.setPriority(Thread.NORM_PRIORITY);
        }
        return t;
    }
}
