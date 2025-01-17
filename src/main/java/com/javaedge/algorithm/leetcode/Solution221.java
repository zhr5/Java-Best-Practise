package com.javaedge.algorithm.leetcode;

public class Solution221 {
    /**
     * 计算给定二维字符数组中最大正方形的面积
     *
     * @param matrix 二维字符数组，其中'1'表示正方形的一部分，'0'表示不是
     * @return 返回最大正方形的面积
     */
    public int maximalSquare(char[][] matrix) {
        // 获取矩阵的行数和列数
        int m = matrix.length;
        int n = matrix[0].length;
        // 初始化动态规划数组
        int[][] dp = new int[m][n];//dp[i][j]表示从(0,0)到(i,j)位置可以形成的最大正方形的边长
        // 初始化最大正方形的边长为0
        int max = 0;
        // 遍历矩阵中的每个元素
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 当前位置可以形成正方形的一部分
                if (matrix[i][j] == '1') {
                    // 如果在边界上，正方形的边长只能是1
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // 计算当前位置可以形成的最大正方形的边长
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }
                    // 更新最大正方形的边长
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        // 返回最大正方形的面积
        return max * max;
    }
}
