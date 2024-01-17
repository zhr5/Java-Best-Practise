package com.javaedge.algorithm.dynamicProgramming;

import java.util.Scanner;

public class bag01 {
        //01背包
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            // 注意 hasNext 和 hasNextLine 的区别
            while (in.hasNextInt()) { // 注意 while 处理多个 case
                int bagV = in.nextInt();//背包最大能容纳的体积
                int n = in.nextInt();//物品个数
                int [] v = new int [n];//v[i]表示编号i的物品的体积
                int [] w = new int [n];//w[i]表示编号i的物品的重量
                int i = 0;
                while (n-- > 0) {
                    v[i] = in.nextInt();
                    w[i++] = in.nextInt();
                }
                int [][] dp = new int [n + 1][bagV+1];
                //dp[i][j]表示在编号0-i中取物品，背包容量为j时能装的最大价值
                for (i = 0; i < n; i++) {//
                    dp[i][0] = 0;
                }
                for (int j = w[0]; j <= bagV; j++) {
                        dp[0][j] = w[0];
                }
                for (i = 1; i < n; i++) {
                    for (int j = 1; j <= bagV; j++) {
                        if (j < w[i]) dp[i][j] = dp[i - 1][j];
                        else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + w[i]);
                    }
                }
                System.out.println(dp[n][bagV]);
            }

        }
}

