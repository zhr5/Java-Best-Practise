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
     * 有效括号子串指的是左括号和右括号正确匹配的子串
     * 使用栈来跟踪每个未匹配的左括号的索引，以便在遇到右括号时，可以计算当前有效子串的长度
     *
     * @param s 输入的字符串，只包含 '(' 和 ')'
     * @return 返回最长有效括号子串的长度
     */
    public static int longestValidParentheses1(String s) {
        // 初始化最大长度为0
        int max = 0;
        // 使用栈来跟踪每个未匹配的左括号的索引
        Deque<Integer> stack = new LinkedList<>();
        // 遍历字符串中的每个字符
        for (int i = 0; i != s.length(); i++) {
            // 如果当前字符是左括号，将其索引入栈
            if (s.charAt(i) == '(')
                stack.push(i);
            else {// 当前字符是右括号
                // 如果栈不为空且栈顶元素是未匹配的左括号，则匹配成功，栈顶元素出栈
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.poll();// 匹配的左括号出栈
                    // 如果栈不为空，计算当前有效子串的长度
                    if (!stack.isEmpty()) {
                        max = Math.max(max, i - stack.peek());
                    } else {
                        // 这里是因为栈内元素全部出栈，说明从头开始的序列都是有效的，那么长度就是当前序号+1
                        max = Math.max(max, i + 1);
                    }
                } else {
                    // 如果当前右括号没有匹配的左括号，将其索引入栈
                    stack.push(i);
                }
            }
        }
        // 返回最长有效括号子串的长度
        return max;
    }


    /**
     * 计算最长的有效括号子串的长度
     * 使用栈来跟踪括号的索引，以确定有效子串的起始和结束位置
     *
     * @param s 输入的字符串，包含括号字符
     * @return 返回最长有效括号子串的长度
     */
    public int longestValidParentheses2(String s) {
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

 /*   撇开方法一提及的动态规划方法，相信大多数人对于这题的第一直觉是找到每个可能的子串后判断它的有效性，但这样的时间复杂度会达到 O(n ^ 3)，
 无法通过所有测试用例。但是通过栈，我们可以在遍历给定字符串的过程中去判断到目前为止扫描的子串的有效性，同时能得到最长有效括号的长度。

    具体做法是我们始终保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」，这样的做法主要是考虑了边界条件的处理，栈里其他元素维护左括号的下标：

    对于遇到的每个 ‘(’ ，我们将它的下标放入栈中
    对于遇到的每个 ‘)’ ，我们先弹出栈顶元素表示匹配了当前右括号：
    如果栈为空，说明当前的右括号为没有被匹配的右括号，我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标」
    如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
    我们从前往后遍历字符串并更新答案即可。

    需要注意的是，如果一开始栈为空，第一个字符为左括号的时候我们会将其放入栈中，这样就不满足提及的「最后一个没有被匹配的右括号的下标」，为了保持统一，我们在一开始的时候往栈中放入一个值为 −1 的元素。

    作者：力扣官方题解
    链接：https://leetcode.cn/problems/longest-valid-parentheses/solutions/314683/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

    public static void main(String[] args) {
        Solution32 solution = new Solution32();
        String s = "()))";
        int result = solution.longestValidParentheses1(s);
        System.out.println("The longest valid parentheses substring length is: " + result);
    }
}
