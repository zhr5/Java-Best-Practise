package com.javaedge.algorithm;

public class Solution10 {
   /* a*指 0个或多个a*/
/*    public boolean isMatch(String s, String p) {
        if(p.equals("*")) return true;
        int m=s.length(),n=p.length();
        int i=0,j=0;
        while(i<m&&j<n){
            if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.'){
                i++;
                j++;
            }else if(p.charAt(j)=='*'){
                i++;
            }else{
                return false;
            }
        }
        if(i<m) return false;
        if(j<n){
            while(j<n){
                if(p.charAt(j)>'a'&&p.charAt(j)<'z') return false;
                if(p.charAt(j)=='.') return false;
                if(p.charAt(j)=='*') return true;
            }
        }
        return true;
    }*/
   public boolean isMatch(String s, String p) {
       int m = s.length() + 1, n = p.length() + 1;
       boolean[][] dp = new boolean[m][n];//dp[i][j]表示s的前i个字符和p的前j个字符是否匹配
       dp[0][0] = true;
       for(int j = 2; j < n; j += 2)
           dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';//
       for(int i = 1; i < m; i++) {
           for(int j = 1; j < n; j++) {
               dp[i][j] = p.charAt(j - 1) == '*' ?
                       dp[i][j - 2] || dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') :
                       dp[i - 1][j - 1] && (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1));
           }
       }
       return dp[m - 1][n - 1];
   }
}
