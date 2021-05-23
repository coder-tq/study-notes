package 尚硅谷面试题第二季;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeSet;
import java.util.WeakHashMap;

/**
 * @author coder_tq
 * @Date 2021/5/23 9:06
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println("=======================");
        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(weakReference.get());

        WeakHashMap<Integer,String> weakHashMap = new WeakHashMap<>();
        Integer key = new Integer(1);
        weakHashMap.put(key,"weakHashMap");
        System.out.println(weakHashMap);
        key = null;
        System.out.println(weakHashMap);
        System.gc();
        System.out.println(weakHashMap);
    }
}
/**
 * java.lang.Object@1b6d3586
 * java.lang.Object@1b6d3586
 * =======================
 * null
 * null
 */
