package com.javaedge.algorithm.leetcode.slidingWindow;

//最小覆盖子串
public class Solution76 {
    public String minWindow(String s, String t) {
        char[] chars = s.toCharArray(), chart = t.toCharArray();
        int n = chars.length, m = chart.length;

        int[] hash = new int[128];
        for (char ch : chart) {
            hash[ch]--;
        }

        String res = "";
        for (int i = 0, j = 0, cnt = 0; i < n; i++) {
            hash[chars[i]]++;
            if (hash[chars[i]] <= 0) {
                cnt++;
            }
            while (cnt == m && hash[chars[j]] > 0) {// cnt 等于 t 的长度 m 时，说明当前窗口包含了 t 中所有字符
                hash[chars[j++]]--;
            }
            if (cnt == m) {
                if (res.equals("") || res.length() > i - j + 1) {
                    res = s.substring(j, i + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = new Solution76().minWindow(s, t);
        System.out.println(res);
    }
}
