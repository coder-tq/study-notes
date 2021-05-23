package 尚硅谷面试题第二季;

/**
 * @author coder_tq
 * @Date 2021/5/22 21:56
 */
public class StrongReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = o1;
        o1 = null;
        System.gc();
        System.out.println(o2);
    }
}
/**
 * 运行结果
 * java.lang.Object@1b6d3586
 */
