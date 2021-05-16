package 尚硅谷面试题第二季;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author coder_tq
 * @Date 2021/5/16 10:41
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        try {

        }catch (Exception e){

        }finally {
            executorService.shutdown();
        }
    }
}
