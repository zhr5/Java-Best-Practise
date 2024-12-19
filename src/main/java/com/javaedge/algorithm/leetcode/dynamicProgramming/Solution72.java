package com.javaedge.algorithm.leetcode.dynamicProgramming;

public class Solution72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // dp[i][j] means the minimum number of operations to transform word1[0:i-1] to word2[0:j-1]
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;//表示word1[0:i-1]变成空字符串需要i次操作
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;//表示word2[0:j-1]变成空字符串需要j次操作
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
