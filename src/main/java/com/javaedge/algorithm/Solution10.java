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
   /**
    * 判断字符串s与模式p是否匹配
    * 通过动态规划的方法解决正则表达式匹配问题
    *
    * @param s 输入的字符串
    * @param p 匹配模式，包含'.'和'*'两种特殊字符
    * @return 如果s与p匹配，返回true；否则返回false
    */
   public boolean isMatch(String s, String p) {
       // m和n分别为字符串s和模式p的长度加1，用于初始化dp数组
       int m = s.length() + 1, n = p.length() + 1;
       // dp[i][j]表示s的前i个字符和p的前j个字符是否匹配
       boolean[][] dp = new boolean[m][n];
       // 初始化空字符串和空模式匹配为true
       dp[0][0] = true;
       // 初始化dp数组第一行，处理模式p以'*'结尾的情况
       for(int j = 2; j < n; j += 2)
           dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
       // 遍历字符串s和模式p的每个字符，填充dp数组
       for(int i = 1; i < m; i++) {
           for(int j = 1; j < n; j++) {
               // 当模式字符为'*'时，考虑两种情况：不使用前面的字符或使用前面的字符
               dp[i][j] = p.charAt(j - 1) == '*' ?
                       dp[i][j - 2] || dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') :
                       // 当模式字符不为'*'时，判断当前字符是否匹配
                       dp[i - 1][j - 1] && (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1));
           }
       }
       // 返回整个dp数组的最后一个值，表示s和p是否匹配
       return dp[m - 1][n - 1];
   }
}
