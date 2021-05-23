package 尚硅谷面试题第二季;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author coder_tq
 * @Date 2021/5/23 16:05
 */
public class ReferenceQueueDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(o1,referenceQueue);
        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());
        System.out.println("===============");

        o1 = null;
        System.gc();

        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

    }
}
