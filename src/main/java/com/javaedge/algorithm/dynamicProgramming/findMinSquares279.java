package com.javaedge.algorithm.dynamicProgramming;

import java.util.Arrays;

public class findMinSquares279 {
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
