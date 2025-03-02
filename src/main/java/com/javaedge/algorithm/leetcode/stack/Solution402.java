package com.javaedge.algorithm.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

public class Solution402 {
    /**
     * 移除字符串中的k个数字，使得剩余的数最小
     * 使用双端队列作为辅助数据结构，实现高效移除和添加数字
     *
     * @param num 原始数字字符串
     * @param k 需要移除的数字个数
     * @return 移除k个数字后得到的最小数字字符串
     */
    public String removeKdigits(String num, int k) {
        // 使用双端队列作为辅助数据结构
        Deque<Character> deque = new LinkedList<Character>();
        int length = num.length();
        // 遍历字符串中的每个数字
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            // 当队列不为空且还有数字需要移除时，比较当前数字与队列尾部数字的大小
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            // 将当前数字添加到队列尾部
            deque.offerLast(digit);
        }
        // 如果还需要移除数字，从队列尾部移除
        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }
        // 构建最终返回的字符串
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        // 移除前导零
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        // 如果最终字符串为空，则返回"0"
        return ret.length() == 0 ? "0" : ret.toString();
    }
}
