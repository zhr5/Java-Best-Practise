package com.javaedge.algorithm.leetcode.dynamicProgramming;

public class Solution5 {
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

}
