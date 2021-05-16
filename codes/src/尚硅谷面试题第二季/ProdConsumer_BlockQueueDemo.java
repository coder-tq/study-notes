package 尚硅谷面试题第二季;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author coder_tq
 * @Date 2021/5/15 10:49
 */
public class ProdConsumer_BlockQueueDemo {
    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));

        new Thread(() -> {
            System.out.println("生产线程启动");
            try {
                myResource.myProd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Prod").start();

        new Thread(() -> {
            System.out.println("消费线程启动");
            try {
                myResource.myConsumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Consumer").start();

        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
        myResource.stop();
    }
}
class MyResource{
    private volatile boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    private BlockingQueue<String> blockingQueue;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void myProd() throws InterruptedException {
        String data;
        boolean retResult;
        while (flag)
        {
            data = atomicInteger.incrementAndGet()+"";
            retResult = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retResult)
            {
                System.out.println(Thread.currentThread().getName()+" 插入队列成功，data:"+data);
            }
            else
            {
                System.out.println(Thread.currentThread().getName()+" 插入队列失败，data:"+data);
            }
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        System.out.println(Thread.currentThread().getName()+" 停！");
    }
    public void myConsumer() throws InterruptedException {
        String retResult;
        while (flag)
        {
            retResult = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (null!=retResult&&!"".equalsIgnoreCase(retResult))
            {
                System.out.println(Thread.currentThread().getName()+" 消费队列成功，data:"+retResult);
            }
            else
            {
                flag = false;
                System.out.println(Thread.currentThread().getName()+" 消费超时");
            }
        }
        System.out.println(Thread.currentThread().getName()+" 停！");
    }
    public void stop(){
        flag = false;
    }
}
