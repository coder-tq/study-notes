package 尚硅谷面试题第二季;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author coder_tq
 * @Date 2021/5/13 22:02
 */
public class BlockingQueueDemo {

    public static void main(String[] args) {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
        System.out.println(arrayBlockingQueue.poll());


    }
}
