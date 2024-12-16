package com.javaedge.algorithm.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MinStack155 {
    Deque<Integer> data;
    Deque<Integer> min;

    public MinStack155() {
        data = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int val) {
        data.push(val);
        if (min.isEmpty()) {
            min.push(val);
        } else {
            if (val <= getMin()) {// 如果新入栈的值小于等于栈顶最小值，则更新最小值
                min.push(val);
            }
        }
    }
   /* 更新时将新的值压入min栈，这意味着如果有多个相同的最小值入栈，只有第一个会被记录。结果是，当弹出最小值时，可能会导致获取到错误的最小值。因此，当最小值等于入栈值时，仍然需要将其压入min栈。
    例如：
    入栈顺序：3, 2, 2, 1，会导致min栈只记录1和2，而忽略3和第二个2的存在。*/

    public void pop() {
        int n = data.pop();
        if (n == getMin()) {
            min.pop();
        }

    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }

    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> min_stack;
        public MinStack() {
            stack = new Stack<>();
            min_stack = new Stack<>();
        }
        public void push(int x) {
            stack.push(x);
            if(min_stack.isEmpty() || x <= min_stack.peek())
                min_stack.push(x);
        }
        public void pop() {
            if(stack.pop().equals(min_stack.peek()))
                min_stack.pop();
        }
        public int top() {
            return stack.peek();
        }
        public int getMin() {
            return min_stack.peek();
        }
    }

}
