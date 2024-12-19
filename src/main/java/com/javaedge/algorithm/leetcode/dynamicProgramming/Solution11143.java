package com.javaedge.algorithm.leetcode.dynamicProgramming;

public class Solution11143 {
    // 计算两个字符串的最长公共子序列长度
/*    public int longestCommonSubsequence1(String text1, String text2) {
        int [] [] dp =new int [text1.length()+1][text2.length()+1];// dp[i][j] 表示text1 的text1[0]...text1[i-1] 和text2[0]...text2[j-1]最长公共子序列
        for(int i=0;i<=text1.length();i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=text2.length();j++){
            dp[0][j]=0;
        }
        int i=1,j=1;
        while(i<text1.length()&&j<text2.length()){
            if(text1.charAt(i)==text2.charAt(j)){
                dp[i][j]=dp[i-1][j-1]+1;
            }else{
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
            i++;
            j++;
        }
        return dp[text1.length()][text2.length()];
    }*/
  public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

}
