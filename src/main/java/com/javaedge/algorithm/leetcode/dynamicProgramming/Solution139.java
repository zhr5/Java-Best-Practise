package com.javaedge.algorithm.leetcode.dynamicProgramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution139 {

    /**
     * 判断字符串是否可以被拆分为字典中的单词组合
     *
     * @param s        待检测的字符串
     * @param wordDict 字典，包含可使用的单词列表
     * @return 如果字符串可以被拆分为字典中的单词组合则返回true，否则返回false
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];// dp[i] 表示 s 的前 i 个字符是否可以切割成字典中的单词
        dp[0] = true;    // 空字符串可以切割
        for (int i = 1; i <= s.length(); i++) {//为什么i从1开始？
            // 遍历所有可能的分割点，检查是否存在有效分割
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {//注意substring是左闭右开的，所有i从1开始表示取第一个字符
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
