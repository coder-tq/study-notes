package 剑指offer;

/**
 * @author coder_tq
 * @Date 2021/5/6 16:55
 */
public class 替换空格 {
    class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param s string字符串
         * @return string字符串
         */
        public String replaceSpace (String s) {
            // write code here
            return s.replaceAll(" ","%20");
        }
    }

}
