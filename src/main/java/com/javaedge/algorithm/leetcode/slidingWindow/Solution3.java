package com.javaedge.algorithm.leetcode.slidingWindow;

import java.util.HashSet;
import java.util.Set;
//无重复最长子串

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int l = 0, r = 0;
        Set<Character> set = new HashSet<>();
        while (l < s.length()) {
            if (res > s.length() - 1 - l) {
                break;
            }
            while (r < s.length() && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
            }

            res = Math.max(res, r - l);
            if (r == s.length()) {
                return res;
            }
            while (l < s.length() && set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
        }
        return res;
    }
    //推荐
    public int lengthOfLongestSubstring1(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            if(res > s.length() - left){
                break;
            }
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                res = Math.max(res, set.size());
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return res;
    }
    public int lengthOfLongestSubstring2(String s) {
        int ans = 0;
        int start = 0, end = 0;
        Set<Character> set = new HashSet<>();

        while (start < s.length()) {
            if (s.length() - start < ans) {
                break;
            }

            // 扩展窗口直到遇到重复字符或到达字符串末尾
            while (end < s.length() && !set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
                ans = Math.max(ans, end - start);
            }
            ans = Math.max(ans, end - start);
            // 移除起始字符，移动窗口起始位置
            if (start < s.length()) {
                set.remove(s.charAt(start));
            }
            start++;
        }

        return ans;
    }
}
