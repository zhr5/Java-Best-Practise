package com.javaedge.algorithm.leetcode.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSquares279Plus {
    //给你一个整数 n ，返回 和为 n 的完全平方数的最少数量的组成集合 。
    public static List<Integer> findMinSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        // 该代码片段通过动态规划的方法，从给定的数值n中逐步减去平方数，
        // 直至n变为0，并将每次减去的平方数添加到结果列表result中。
        while (n > 0) {
            for (int j = 1; j * j <= n; j++) {
                if (dp[n] == dp[n - j * j] + 1) {// 找到了最少的平方数，将其添加到结果列表中，并将n减去该平方数
                    // 如果dp[n]等于dp[n - j * j]加1，说明当前的j * j是构成n的其中一个平方数
                    result.add(j * j);
                    n -= j * j;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 18;
        System.out.println(findMinSquares(n));
    }
}
