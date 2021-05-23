package 尚硅谷面试题第二季;

import java.lang.ref.SoftReference;

/**
 * @author coder_tq
 * @Date 2021/5/22 22:22
 */
public class SoftReferenceDemo {
    public static void softRef_Memory_Enough(){
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        System.gc();

        System.out.println(o1);
        System.out.println(softReference.get());
    }

    /**
     * -Xms5m -Xmx5m -XX:PrintGCDetails
     */

    public static void softRef_Memory_NotEnough(){
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;

        try {
            byte[] bytes = new byte[30*1024*1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        }

    }

    public static void main(String[] args) {
        softRef_Memory_Enough();
        System.out.println("=====================");
        softRef_Memory_NotEnough();
    }
}
/**
 * [GC (Allocation Failure) [PSYoungGen: 1024K->504K(1536K)] 1024K->616K(5632K), 0.0013217 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * java.lang.Object@1b6d3586
 * java.lang.Object@1b6d3586
 * [GC (System.gc()) [PSYoungGen: 1078K->504K(1536K)] 1190K->680K(5632K), 0.0007707 secs] [Times: user=0.09 sys=0.00, real=0.00 secs]
 * [Full GC (System.gc()) [PSYoungGen: 504K->0K(1536K)] [ParOldGen: 176K->598K(4096K)] 680K->598K(5632K), [Metaspace: 3115K->3115K(1056768K)], 0.0053373 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 * null
 * java.lang.Object@1b6d3586
 * =====================
 * java.lang.Object@4554617c
 * java.lang.Object@4554617c
 * [GC (Allocation Failure) [PSYoungGen: 30K->128K(1536K)] 629K->726K(5632K), 0.0004730 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [GC (Allocation Failure) [PSYoungGen: 128K->96K(1536K)] 726K->694K(5632K), 0.0003076 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [Full GC (Allocation Failure) [PSYoungGen: 96K->0K(1536K)] [ParOldGen: 598K->595K(4096K)] 694K->595K(5632K), [Metaspace: 3120K->3120K(1056768K)], 0.0054428 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [GC (Allocation Failure) [PSYoungGen: 0K->0K(1536K)] 595K->595K(5632K), 0.0003311 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [Full GC (Allocation Failure) [PSYoungGen: 0K->0K(1536K)] [ParOldGen: 595K->576K(4096K)] 595K->576K(5632K), [Metaspace: 3120K->3120K(1056768K)], 0.0054780 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
 * null
 * null
 * Heap
 *  PSYoungGen      total 1536K, used 117K [0x00000000ffe00000, 0x0000000100000000, 0x0000000100000000)
 *   eden space 1024K, 11% used [0x00000000ffe00000,0x00000000ffe1d720,0x00000000fff00000)
 *   from space 512K, 0% used [0x00000000fff00000,0x00000000fff00000,0x00000000fff80000)
 *   to   space 512K, 0% used [0x00000000fff80000,0x00000000fff80000,0x0000000100000000)
 *  ParOldGen       total 4096K, used 576K [0x00000000ffa00000, 0x00000000ffe00000, 0x00000000ffe00000)
 *   object space 4096K, 14% used [0x00000000ffa00000,0x00000000ffa90260,0x00000000ffe00000)
 *  Metaspace       used 3194K, capacity 4500K, committed 4864K, reserved 1056768K
 *   class space    used 346K, capacity 388K, committed 512K, reserved 1048576K
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 */
