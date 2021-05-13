package 剑指offer;

import java.util.Stack;

/**
 * @author coder_tq
 * @Date 2021/5/6 20:12
 */
public class 用两个栈实现队列 {
    class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if (!stack2.empty()){
                return stack2.pop();
            }
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}
