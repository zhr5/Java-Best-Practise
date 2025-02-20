package com.javaedge.algorithm.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution227 {
    /**
     * 计算包含加减乘除的基本数学表达式字符串结果
     *
     * @param s 输入表达式字符串，支持数字、空格及+ - * /运算符
     * @return 表达式计算的整数结果，除法按整数运算舍去小数部分
     */
    public int calculate(String s) {
        int len = s.length();
        Deque<Integer> stack = new ArrayDeque<>();
        char preSign = '+'; // 前一个运算符，初始化为+处理首个数字
        int num = 0;

        // 遍历字符串处理每个字符
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            // 累积数字字符转换为整数
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }

            /* 遇到新运算符或到末尾时，处理前一个运算符对应的计算逻辑
             * 注意：i == len-1 确保最后一个数字被处理
             */
            if (!Character.isDigit(c) && c != ' ' || i == len - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num); // 负数入栈便于后续统一加法处理
                        break;
                    case '*':
                        stack.push(stack.pop() * num); // 立即计算乘法保证优先级
                        break;
                    case '/':
                        // 处理整数除法
                        int prev = stack.pop();
                        stack.push(prev / num); // Java自动向零取整
                        break;
                    default:
                        break;
                }
                preSign = c; // 更新前一个运算符
                num = 0;
            }
        }

        // 处理栈中剩余元素的累加求和
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

}
