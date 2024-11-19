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
}
