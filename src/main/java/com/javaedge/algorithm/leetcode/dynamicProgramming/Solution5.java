package com.javaedge.algorithm.leetcode.dynamicProgramming;

public class Solution5 {
    //中心扩展法，时间复杂度O(n^2)
    // 思路：
    // 遍历字符串的每个字符，尝试找到以该字符为中心的最长回文子串。
    // 对于每个字符，我们可以尝试以它为中心，向两边扩展，看是否存在回文子串。
    // 如果存在，则更新最长回文子串的长度和起始和结束位置。
    // 时间复杂度：O(n^2)，其中 n 是字符串的长度。
    // 空间复杂度：O(1)，只需要常数的空间。
    public String longestPalindrome(String s) {
        // 如果字符串为空或长度为0，返回空字符串
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0, end = 0;
        // 遍历字符串的每个字符，尝试找到以该字符为中心的最长回文子串
        for (int i = 0; i < s.length(); i++) {
            // 计算以单个字符为中心的回文长度
            int len1 = expandAroundCenter(s, i, i);
            // 计算以两个字符为中心的回文长度
            int len2 = expandAroundCenter(s, i, i + 1);
            // 取两种情况下的最大长度
            int len = Math.max(len1, len2);
            // 如果当前找到的回文长度大于之前记录的最大长度，更新起始和结束位置
            if (len > end - start) {
                start = i - (len - 1) / 2;// 计算起始位置
                end = i + len / 2;// 计算结束位置
            }
        }
        // 返回最长回文子串
        return s.substring(start, end + 1);
    }
/*
    具体例子
    假设字符串为 "babad"，当遍历到 i = 1 时：
    如果以 i = 1 为中心的最长回文子串是 "bab"，则 len = 3。
    起始位置 start = 1 - (3 - 1) / 2 = 0。
    结束位置 end = 1 + 3 / 2 = 2。
    最终返回的子串为 s.substring(0, 3)，即 "bab"。*/

    private int expandAroundCenter(String s, int left, int right) {
        // 从中心向两边扩展，计算回文子串的长度
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        // 返回回文子串的长度
        return R - L - 1;
    }

    // 动态规划法，时间复杂度O(n^2) 空间复杂度O(n^2)
    // 思路：
    // 定义状态数组 dp[i][j]，表示 s[i...j] 是否为回文串。
    // 状态转移方程：
    // 如果 s[i] == s[j]，且 s[i+1...j-1] 为回文串，则 s[i...j] 为回文串。
    // 时间复杂度：O(n^2)，其中 n 是字符串的长度。
    // 空间复杂度：O(n^2)，其中 n 是字符串的长度。

    public String longestPalindrome1(String s) {
        // 如果字符串为空或长度为0，返回空字符串
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        // 定义状态数组 dp[i][j]，表示 s[i...j] 是否为回文串
        boolean[][] dp = new boolean[n][n];
        // 全部初始化为 false
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = false;
            }
        }
        // 全部初始化为 true，表示长度为 1 的子串都是回文串
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        // 遍历字符串的每个字符，尝试找到以该字符为中心的最长回文子串
        int start = 0, end = 0;
        /*这段代码从后往前遍历字符串的原因是为了确保在检查 s[i...j] 是否为回文串时，dp[i+1][j-1] 的值已经被正确计算。具体来说：
        动态规划的状态转移依赖于子问题的解。
        如果从前往后遍历，当检查 s[i...j] 时，dp[i+1][j-1] 可能还未被计算，导致错误的结果。
        从后往前遍历可以保证在检查 s[i...j] 时，dp[i+1][j-1] 已经被计算过，从而确保状态转移的正确性。*/
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 如果 s[i] == s[j]，且 s[i+1...j-1] 为回文串，则 s[i...j] 为回文串
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    // 如果当前找到的回文长度大于之前记录的最大长度，更新起始和结束位置
                    if (j - i + 1 > end - start) {
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

}
