package com.javaedge.algorithm.leetcode.slidingWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//找到字符串中的所有字母异位词
public class Solution438 {
    /**
     * 寻找字符串 s 中所有 p 的异位词的起始索引
     *
     * @param s 输入的字符串
     * @param p 指定的异位词
     * @return 返回所有 p 的异位词的起始索引的列表
     */
    public List<Integer> findAnagrams(String s,String p){
        // s 和 p 的长度
        int sLen = s.length();
        int pLen = p.length();

        // 如果 s 的长度小于 p 的长度，直接返回空列表
        if (sLen < pLen) {
            return new ArrayList<>();
        }

        // 存储 p 和 s 中字符的频率
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // 计算 p 中每个字符的频率
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // 存储结果的列表
        List<Integer> result = new ArrayList<>();

        // 滑动窗口的左右指针
        int left = 0;
        int right = 0;

        // 遍历 s，寻找所有异位词
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

    /**
     * 比较两个数组是否相等
     *
     * @param sCount 第一个数组
     * @param pCount 第二个数组
     * @return 如果两个数组相等返回 true，否则返回 false
     */
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
