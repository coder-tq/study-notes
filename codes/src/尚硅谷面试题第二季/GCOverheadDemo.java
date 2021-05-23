package 尚硅谷面试题第二季;

import java.util.ArrayList;
import java.util.List;

/**
 * @author coder_tq
 * @Date 2021/5/23 16:27
 */
public class GCOverheadDemo {
    public static void main(String[] args) {
        int i = 1;
        List<String> list = new ArrayList<>();
        try {
            while (true){
                list.add(String.valueOf(++i).intern());
            }
        } catch (Throwable e){
            System.out.println("==============");
            System.out.println(i);
            throw e;
        }
    }
}
