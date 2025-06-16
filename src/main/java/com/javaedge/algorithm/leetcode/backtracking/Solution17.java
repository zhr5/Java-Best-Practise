package com.javaedge.algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Solution17 {
    // 17. 电话号码的字母组合
    // 创建一个映射，将数字字符与可能的字母组合映射起来
    Map<Character, String> mp = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };
    // 存储所有可能的字母组合结果
    List<String> res = new ArrayList<>();
    // 用于临时存储当前的字母组合
    StringBuffer tmp = new StringBuffer();

    /**
     * 主要功能函数，返回电话号码的字母组合列表
     * @param digits 输入的数字字符串
     * @return 包含所有组合的列表
     */
    public List<String> letterCombinations(String digits) {
        // 如果输入为空，直接返回空的结果列表
        if (digits.length() == 0) return res;
        // 从第一个数字开始回溯
        backtrack(mp, digits, 0);
        return res;
    }

    /**
     * 回溯函数，生成电话号码的字母组合
     * @param phoneMap 数字到字母的映射
     * @param digits 输入的数字字符串
     * @param index 当前处理的数字索引
     */
    public void backtrack(Map<Character, String> phoneMap, String digits, int index) {
        // 如果当前索引等于输入长度，说明已经找到一个完整的组合，将其添加到结果列表中
        if (index == digits.length()) {
            res.add(tmp.toString());
        } else {
            // 获取当前数字字符
            char digit = digits.charAt(index);
            // 获取当前数字对应的所有可能的字母
            String letters = phoneMap.get(digit);
            // 遍历当前数字对应的所有可能的字母
            for (int i = 0; i < letters.length(); i++) {
                // 将当前字母添加到临时字符串中
                tmp.append(letters.charAt(i));
                // 递归调用，处理下一个数字字符
                backtrack(phoneMap, digits, index + 1);
                // 回溯，删除最后一个添加的字母，尝试下一个可能的字母
                tmp.deleteCharAt(tmp.length() - 1);
            }
        }
    }
}
