package com.javaedge.algorithm.leetcode.greedyAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Solution763 {
    public List<Integer> partitionLabels(String s) {
        // 记录每个字符最后出现的位置
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        // 初始化起始和结束位置
        int start = 0, end = 0;
        // 存储每个区间的长度
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            // 更新当前区间的结束位置
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            // 如果当前位置等于结束位置，说明找到了一个完整的区间
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        // 返回所有区间的长度
        return result;
    }

}
