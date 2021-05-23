package 尚硅谷面试题第二季;

import java.util.HashSet;
import java.util.Set;

/**
 * @author coder_tq
 * @Date 2021/5/22 17:23
 */
public class StringGCDemo {
    public static void main(String[] args) {
        Set<String> st = new HashSet<>();
        String string = "";
        for (int i = 0; i < 100000; i++) {
            //System.out.println(string);
            string+=i;
            st.add(string);
        }
    }
}
