package com.javaedge.algorithm.leetcode.dynamicProgramming;

/*给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
        完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
        例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
        示例 1：
        输入：n = 12
        输出：3
        解释：12 = 4 + 4 + 4

        示例 2：
        输入：n = 13
        输出：2
        解释：13 = 4 + 9

        提示：
        1 <= n <= 10^4*/

import java.util.Arrays;

public class Solution279 {
    //背包容量n，物品大小1 4 9 16 ...求达到容量n的最小物品数，物品可重复取(完全背包)
    //物品数组nums {1,4,9,16,...根号n}
    public int numSquares(int n) {
        int [] dp=new int [n+1];//dp[i]表示和为 i 的完全平方数的最少数量 dp[j]=min(dp[j-i*i]+1,dp[j])
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                dp[i]=Math.min(dp[i-j*j]+1,dp[i]);
            }
        }
        return dp[n];
    }
}
 /* j 在增长过程中负责遍历所有可能的完全平方数，并为当前和 i 提供组合选择。
  每增加一个 j，就会对 dp 数组进行相应更新，确保所有可能的组合都得到考虑，从而找到和为 i 的最小完全平方数数量。*/