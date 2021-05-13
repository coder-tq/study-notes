package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author coder_tq
 * @Date 2021/5/6 16:56
 */
public class 从尾到头打印链表 {

    class Solution {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            while (listNode != null) {
                stack.push(listNode.val);
                System.out.println(listNode.val);
                listNode = listNode.next;
            }
            while (!stack.empty()) {
                arrayList.add(stack.pop());
            }
            return arrayList;
        }
    }
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}




