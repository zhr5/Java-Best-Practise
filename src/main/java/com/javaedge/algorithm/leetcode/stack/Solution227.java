package com.javaedge.algorithm.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution227 {
    public int calculate(String s) {
        int len = s.length();
        Deque<Integer> stack = new ArrayDeque<>();
        char preSign = '+';
        int num = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (!Character.isDigit(c) && c != ' ' || i == len - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        // 处理整数除法
                        int prev = stack.pop();
                        stack.push(prev / num);
                        break;
                    default:
                        break;
                }
                preSign = c;
                num = 0;
            }
        }

        // 处理最后一位数字
        switch (preSign) {
            case '+':
                stack.push(num);
                break;
            case '-':
                stack.push(-num);
                break;
            case '*':
                stack.push(stack.pop() * num);
                break;
            case '/':
                int prev = stack.pop();
                stack.push(prev / num);
                break;
            default:
                break;
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
