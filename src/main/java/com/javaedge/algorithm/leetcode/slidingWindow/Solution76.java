package com.javaedge.algorithm.leetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

//最小覆盖子串
public class Solution76 {
    public String minWindow(String s, String t) {
        // 将输入字符串s转换为字符数组，方便后续逐个字符处理
        char[] chars = s.toCharArray();
        // 将输入字符串t转换为字符数组，同样方便后续处理
        char[] chart = t.toCharArray();

        // 存储字符串s的长度
        int n = chars.length;
        // 存储字符串t的长度
        int m = chart.length;

        // 创建一个长度为128的整数数组hash，用于统计字符的出现情况
        // 这里利用了ASCII码值作为数组索引，因为常见字符的ASCII码值范围在0 - 127之间
        // 初始化时，对于目标字符串t中的每个字符ch，将hash[ch]的值减1
        // 表示目标字符串t中这些字符初始是缺少的状态（后续通过窗口移动来使其达到合适的出现次数）
        int[] hash = new int[128];
        for (char ch : chart) {
            hash[ch]--;
        }

        // 用于存储最终找到的最小覆盖子串，初始化为空字符串
        String res = "";

        // 开始滑动窗口的遍历过程
        // i作为滑动窗口的右指针，初始值为0，用于界定窗口的右边界
        // j作为滑动窗口的左指针，初始值为0，用于界定窗口的左边界
        // cnt用于记录当前窗口内已经匹配上目标字符串t中字符的个数
        for (int i = 0, j = 0, cnt = 0; i < n; i++) {
            // 将当前右指针i指向的字符chars[i]在hash数组中的值加1
            // 表示该字符在窗口内又出现了一次
            hash[chars[i]]++;

            // 如果hash[chars[i]] <= 0，说明当前窗口内该字符的出现次数已经使得其相对于目标字符串t中的该字符达到了一种“不缺少”的状态
            // 可能刚好匹配，也可能已经超过匹配所需的次数，此时将cnt的值加1
            // 表示又有一个目标字符串t中的字符在当前窗口内得到了匹配
            if (hash[chars[i]] <= 0) {
                cnt++;
            }

            // 当cnt的值等于目标字符串t的长度m时，说明当前窗口已经包含了目标字符串t的所有字符
            // 此时进入收缩窗口的逻辑
            while (cnt == m && hash[chars[j]] > 0) {
                // 将当前左指针j指向的字符chars[j]在hash数组中的值减1
                // 表示该字符在窗口内的出现次数减少一次，同时左指针j右移一位（通过j++）
                // 这样做是因为该字符在当前窗口内的出现次数比目标字符串t中该字符的出现次数多，此时可以收缩窗口去掉多余的该字符
                hash[chars[j++]]--;
            }

            // 当cnt的值等于m时，也就是当前窗口包含了目标字符串t的所有字符时
            // 进一步判断是否需要更新最小覆盖子串
            if (cnt == m) {
                // 如果当前找到的最小覆盖子串res为空字符串或者当前窗口的长度（i - j + 1）小于res的长度
                // 就将res更新为当前窗口对应的子串，即通过s.substring(j, i + 1)来获取并赋值给res
                if (res.equals("") || res.length() > i - j + 1) {
                    res = s.substring(j, i + 1);
                }
            }
        }

        // 返回最终找到的最小覆盖子串
        return res;
    }

    public String minWindow1(String s, String t) {
        int m = s.length(), n = t.length();
        Map<Character, Integer> TargetMapCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            TargetMapCount.put(c, TargetMapCount.getOrDefault(c, 0) - 1);
        }
        int l = 0, r = 0, matched = 0;
        int[] resIndex = new int[]{0, 0};
        //先向右移动窗口得到有效子串，再左移收缩窗口优化
        while (r < m) {
            if (r < m && TargetMapCount.containsKey(s.charAt(r))) {
                TargetMapCount.put(s.charAt(r), TargetMapCount.get(s.charAt(r)) + 1);
                if (TargetMapCount.get(s.charAt(r)) <= 0) {//说明匹配完一个字符s.charAt(r),即使字符重复
                    matched++;
                }
            }
            r++;
            //尝试收缩窗口
            while (matched == n) {
                if (resIndex[1] - resIndex[0] == 0 || r - l < resIndex[1] - resIndex[0]) {
                    resIndex[0] = l;
                    resIndex[1] = r;//本来应该是r-1，但是后面使用subString方法左闭右开
                }

                if (l < m && TargetMapCount.containsKey(s.charAt(l))) {
                    TargetMapCount.put(s.charAt(l), TargetMapCount.get(s.charAt(l)) - 1);//左移要把已匹配的s.charAt(l)还原
                    if (TargetMapCount.get(s.charAt(l)) > 0) { //s.charAt(l)匹配不完了 试试AABBC  ABC
                        matched--;
                    }
                }
                l++;
            }

        }
        return s.substring(resIndex[0], resIndex[1]);

    }

    public static void main(String[] args) {
/*        String s = "ADOBECODEBANC";
        String t = "ABC";*/
        String s = "AA";
        String t = "AA";
        String res = new Solution76().minWindow1(s, t);
        System.out.println(res);
    }
}
