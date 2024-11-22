package com.javaedge.algorithm.leetcode.slidingWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//找到字符串中的所有字母异位词
public class Solution438 {
    public List<Integer> findAnagrams(String s,String p){
        int sLen = s.length();
        int pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<>();
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // 计算 p 中每个字符的频率
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        List<Integer> result = new ArrayList<>();

        // 滑动窗口
        int left = 0;
        int right = 0;

        while (right < sLen) {
            // 扩展窗口
            char currentChar = s.charAt(right);
            sCount[currentChar - 'a']++;
            right++;

            // 当窗口大小等于 p 的长度时，比较 sCount 和 pCount
            while (right - left == pLen) {
                if (matches(sCount, pCount)) {
                    result.add(left);
                }
                // 收缩窗口
                char leftChar = s.charAt(left);
                sCount[leftChar - 'a']--;
                left++;
            }
        }

        return result;
    }
     // 比较两个数组是否相等
    private boolean matches(int[] sCount, int[] pCount) {
        for (int i = 0; i < 26; i++) {
            if (sCount[i] != pCount[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        String s="cbaebabacd";
        String p="abc";
        Solution438 solution = new Solution438();
        System.out.println(solution.findAnagrams(s,p));
    }
}
