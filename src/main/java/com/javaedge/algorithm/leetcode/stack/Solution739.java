package com.javaedge.algorithm.leetcode.stack;

import java.util.Stack;

public class Solution739 {
    /*    public int[] dailyTemperatures(int[] temperatures) {
            if (temperatures.length == 1)
                return new int[]{0};
            Deque<Integer> stack = new LinkedList<>();// 单调递减栈，存储下标
            int[] res = new int[temperatures.length];
            stack.push(0);
            for (int i = 1; i < temperatures.length; i++) {
                int t = temperatures[stack.peek()];
                while (!stack.isEmpty()) {
                    if (temperatures[i] >t) {
                        int j = stack.pop();
                        res[j] = i - j;
                    }else {
                        break;
                    }
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                res[stack.pop()] = 0;
            }
            return res;
        }*/
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!st.isEmpty() && T[i] > T[st.peek()]) {
                ans[st.peek()] = i - st.pop();
            }
            st.push(i);
        }
        return ans;
    }
}

