package com.javaedge.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution151 {
    /**
     * 反转字符串中的单词
     * 给定一个字符串，逐个翻转字符串中的每个单词
     * 单词由空格分隔，字符串中至少有一个单词
     *
     * @param s 输入的字符串
     * @return 反转单词后的字符串
     */
    public String reverseWords(String s) {
        // 存储分割后的单词
        List<String> words = new ArrayList<>();
        // 标记当前单词的开始位置
        int start = 0;
        // 遍历字符串中的每个字符
        for (int i = 0; i < s.length(); i++) {
            // 遇到空格，表示找到了一个单词
            if (s.charAt(i) == ' ') {
                // 如果start小于i，表示找到了一个非空单词
                if (start < i) {
                    // 将单词添加到列表中
                    words.add(s.substring(start, i));
                }
                // 更新下一个单词的开始位置
                start = i + 1;
            }
        }
        // 处理最后一个单词（或字符串末尾）
        if (start < s.length()) {
            // 将最后一个单词添加到列表中
            words.add(s.substring(start));
        }
        // 将单词列表反转，以实现单词顺序的反转
        Collections.reverse(words);
        // 使用空格连接反转后的单词列表，并返回结果字符串
        return String.join(" ", words);
    }
    public String reverseWords1(String s) {
        s = s.trim();                                    // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;     // 搜索首个空格
            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while (i >= 0 && s.charAt(i) == ' ') i--;     // 跳过单词间空格
            j = i;                                       // j 指向下个单词的尾字符
        }
        return res.toString().trim();                    // 转化为字符串并返回
    }
    public String reverseWords2(String s) {
        String[] strs = s.trim().split(" ");        // 删除首尾空格，分割字符串
        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) { // 倒序遍历单词列表
            if (strs[i].equals("")) continue;        // 遇到空单词则跳过
            res.append(strs[i] + " ");              // 将单词拼接至 StringBuilder
        }
        return res.toString().trim();               // 转化为字符串，删除尾部空格，并返回
    }
    public static void main(String[] args) {
        Solution151 solution = new Solution151();
        String s = "the sky is blue";
        System.out.println(solution.reverseWords(s));
        System.out.println(solution.reverseWords1(s));
        System.out.println(solution.reverseWords2(s));
    }

}
