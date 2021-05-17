package 尚硅谷面试题第二季;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author coder_tq
 * @Date 2021/5/16 9:28
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask,"AA").start();
        futureTask.get();
    }
}

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"Come in");
        try { TimeUnit.MILLISECONDS.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        return 1024;
    }
}
