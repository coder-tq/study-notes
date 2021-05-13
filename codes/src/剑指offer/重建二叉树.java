package 剑指offer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author coder_tq
 * @Date 2021/5/6 18:35
 */
public class 重建二叉树 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] pre = {1,2,3,4,5,6,7};
//        int[] in = {3,2,4,1,6,5,7};
        int[] pre = {};
        int[] in = {};

        System.out.println(solution.reConstructBinaryTree(pre, in));

    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
            return buildTree(pre,in,0, pre.length-1, 0,in.length-1);
        }

        public TreeNode buildTree(int[] pre,int[] in,int preStart,int preEnd,int inStart,int inEnd) {
            if (preEnd < preStart) return null;
            int root = pre[preStart];
            TreeNode treeNode = new TreeNode(root);
            if (preEnd == preStart) return treeNode;
            for (int i = inStart; i <= inEnd; i++) {
                if (root == in[i]) {
                    treeNode.left = buildTree(pre,in,preStart+1,preStart+i-inStart,inStart,i-1);
                    treeNode.right = buildTree(pre,in,preEnd-(inEnd-i)+1,preEnd,i+1,inEnd);
                }
            }
            return treeNode;
        }
    }
}
