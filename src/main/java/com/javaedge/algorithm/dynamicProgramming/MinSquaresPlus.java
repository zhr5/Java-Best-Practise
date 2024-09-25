package com.javaedge.algorithm.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class MinSquaresPlus {
    //给你一个整数 n ，返回 和为 n 的完全平方数的最少数量的组成集合 。
    public static List<Integer> findMinSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (n > 0) {
            for (int j = 1; j * j <= n; j++) {
                if (dp[n] == dp[n - j * j] + 1) {
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
