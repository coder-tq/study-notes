package 剑指offer;

import java.util.Arrays;

/**
 * @author coder_tq
 * @Date 2021/5/6 16:32
 */
public class 二维数组中的查找 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(solution.Find(2, array));
    }
    static class Solution {
        public boolean Find(int target, int [][] array) {
            int length = array.length;
            for (int[] ints : array) {
                if (find(target, ints)) {
                    return true;
                }
            }
            return false;
        }

        private boolean find(int target,int [] array)
        {
            int length = array.length;
            int l = 0;
            int r = length-1;
            int mid;
            int midVal;
            while(l <= r)
            {
                mid = (l+r)/2;
                midVal = array[mid];
                if(target > midVal) {
                    l = mid+1;
                } else if(target < midVal) {
                    r = mid-1;
                }
                else {
                    return true;
                }
            }
            return false;
        }

    }


}
