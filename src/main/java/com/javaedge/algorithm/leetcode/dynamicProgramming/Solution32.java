package com.javaedge.algorithm.leetcode.dynamicProgramming;

import com.javaedge.common.B;

import java.util.Deque;
import java.util.LinkedList;

public class Solution32 {
    /**
     * 计算最长的有效括号子串的长度
     * 有效括号子串指的是左括号和右括号能正确匹配的子串
     *
     * @param s 输入的字符串，只包含 "(" 和 ")"
     * @return 最长有效括号子串的长度
     */
    public int longestValidParentheses(String s) {
        // 初始化最大有效括号子串长度为0
        int maxans = 0;
        // 创建一个数组dp，用于动态规划中记录到当前位置为止的最长有效括号子串长度
        int[] dp = new int[s.length()];// dp[i]表示到第i个位置为止的最长有效括号子串长度

        // 遍历字符串中的每个字符，从第二个字符开始
        for (int i = 1; i < s.length(); i++) {
            // 如果当前字符是右括号，尝试更新dp数组
            if (s.charAt(i) == ')') {
                // 如果前一个字符是左括号，说明找到了一对匹配的括号
                if (s.charAt(i - 1) == '(') {
                    // 更新dp[i]，如果i-2位置有效，则加上dp[i-2]的值，否则为0，然后加上2（当前匹配的一对括号）
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // 如果前一个字符是右括号，且该右括号之前有匹配的左括号
                    // 更新dp[i]，加上dp[i-1]的值（前一个右括号匹配的长度），再向前找一对匹配括号的长度，然后加上2
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                // 更新最大有效括号子串长度
                maxans = Math.max(maxans, dp[i]);
            }
        }
        // 返回最大有效括号子串长度
        return maxans;
    }

/*
    # 代码解释
    这段代码中的 `dp[i - dp[i - 1] - 2]` 是为了处理更长的有效括号子串。具体来说：

            - `dp[i - 1]` 表示到前一个位置为止的最长有效括号子串长度。
            - `i - dp[i - 1] - 1` 位置是与当前右括号匹配的左括号。
            - `i - dp[i - 1] - 2` 位置则是该匹配对之前的字符位置。

    如果 `i - dp[i - 1] - 2` 位置存在并且有效（即在字符串范围内），则它前面也可能存在一个有效的括号子串。因此，加上 `dp[i - dp[i - 1] - 2]` 的值可以将这些连续的有效括号子串连接起来，从而计算出更长的有效括号子串长度。
*/




    /**
     * 计算最长的有效括号子串的长度
     * 使用栈来跟踪括号的索引，以确定有效子串的起始和结束位置
     *
     * @param s 输入的字符串，包含括号字符
     * @return 返回最长有效括号子串的长度
     */
    public int longestValidParentheses1(String s) {
        // 初始化最大长度为0
        int maxans = 0;
        // 使用栈来跟踪括号的索引
        Deque<Integer> stack = new LinkedList<Integer>();
        // 在栈中压入一个初始值-1，作为第一个无效括号之前的索引
        stack.push(-1);
        // 遍历输入字符串中的每个字符
        for (int i = 0; i < s.length(); i++) {
            // 如果当前字符是左括号，将其索引压入栈中
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // 如果当前字符是右括号，弹出栈顶的左括号索引
                stack.pop();
                // 如果栈为空，说明当前右括号没有匹配的左括号，将当前索引压入栈中作为新的无效括号之前的索引
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    // 如果栈不为空，计算当前有效子串的长度，并更新最大长度
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        // 返回最大有效括号子串的长度
        return maxans;
    }

    public static void main(String[] args) {
        Solution32 solution = new Solution32();
        String s = ")()())";
        int result = solution.longestValidParentheses1(s);
        System.out.println("The longest valid parentheses substring length is: " + result);
    }
}
