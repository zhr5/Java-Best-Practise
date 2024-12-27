package com.javaedge.algorithm.leetcode.dynamicProgramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];// dp[i] 表示 s 的前 i 个字符是否可以切割成字典中的单词
        dp[0] = true;    // 空字符串可以切割
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
        }
}
